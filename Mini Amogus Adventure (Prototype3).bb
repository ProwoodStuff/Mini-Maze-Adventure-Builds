 rem Game: Mini Amogus Adventure 
 rem Console: Atari 2600
 rem Reigon: NTSC (North America)
 rem Year: 2023
 rem Month: January
 rem Date: 12th
 rem Day: Thursday
 
 set tv NTSC
 score = score + 1
 rem if score = 0 then reboot
 const noscore = 1
   
   
 playfield:
   XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
   .......................X........
   .......................X........
   X...XXXXXXXXXX....XXXXXXXXXX...X
   X...X........X........X........X
   X...X...XXXXXX....XXXXX........X
   X.......X....X........X....X...X
   X...XXXXX....X........X...XXXXXX
   X............XXXX...XXX...X....X
   X..............................X
   XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
end
 scorecolor = 55
 PF0 = %10000000
 const pfrowheight=8


   missile0x =143
   missile0y = 24
   missile0height = 16


   player0:
        %00101000
        %00111000
        %01111100
        %00111000
        %01111100
        %01111000
        %01111000
        %01111110
end


 player0x = 1
 player0y = 20

 COLUPF = 10
 COLUBK = 7

mainloop
 drawscreen
 
  if collision(player0,playfield) then player0x = 1
  if collision(player0,playfield) then player0y = 20
  if collision(player0,missile0) then score = score + 1
  if collision(player0,missile0) then pfclear %10101010
  if collision(player0,missile0) then player0x = 1
  if collision(player0,missile0) then player0y = 20
  if collision(player0,missile0) then playfield:
   XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
   ........................X.......
   ...................X....X.......
   XXX...XXXXXX..XXX..X....XXX....X
   X.X........X....X..X....X......X
   X.X........X....X..XXX......XXXX
   X.X........X...XX..X.X.........X
   X.XXX....XXX....X..X.XXXXX.....X
   X..........X...................X
   X..............................X
   XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
end
  if collision(player0,missile0) then  COLUPF = 10
  if collision(player0,missile0) then  COLUBK = 20
  if collision(player0,missile0) then  missile0height = 0
  if collision(player0,missile0) then  missile0x = 0
  if collision(player0,missile0) then  missile0y = 0
  if collision(player0,missile0) then  missile1y = 24
  if collision(player0,missile0) then  missile1x = 142
  if collision(player0,missile0) then  missile1height = 16
  if collision(player0,missile1) then playfield:
   XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
   ....X........X...........X......
   ....X........X...........X......
   X...X........XXXXXXX..XXXX...XXX
   X...X.....XXXX.....X...........X
   X...X.....X........X...........X
   X...X..............X.....X.....X
   X...XXXX..XXXXXX...XX...XX.....X
   X.........X..............X.....X
   X.........X....X.........X.....X
   XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
end
  if collision(player0,missile1) then  COLUPF = 50
  if collision(player0,missile1) then  COLUBK = 110
  if collision(player0,missile1) then score = score + 1
  if collision(player0,missile1) then  missile1height = 0
  if collision(player0,missile1) then  missile1x = 0
  if collision(player0,missile1) then  missile1y = 0
  if collision(player0,missile1) then player0x = 1
  if collision(player0,missile1) then player0y = 20
  if collision(player0,missile1) then  ballheight = 16
  if collision(player0,missile1) then  ballx = 142
  if collision(player0,missile1) then  bally = 24
  
  
  if collision(player0,ball) then reboot
  ;  XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
  ;  X..............................X
  ;  X.XXXXX.X....X.XXXXX.X.X.X.X.X.X
  ;  X.X.....X....X.X.....X.X.X.X.X.X
  ;  X.XXXXX.X....X.XXXXX.X.X.X.X.X.X
  ;  X.....X.X....X.....X...........X
  ;  X.XXXXX.XXXXXX.XXXXX.X.X.X.X.X.X
  ;  X..............................X
  ;  X..............................X
  ;  X..............................X
  ;  XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX end




  if joy0right then player0x = player0x + 1
    if joy0right then player0:
      %00101000
      %00111000
      %01111100
      %00111000
      %01111100
      %01111000
      %01111000
      %01111110
end

  if joy0left then player0x = player0x - 1
    if joy0left then player0:
      %00010100
      %00011100
      %00111110
      %00011100
      %00111110
      %00011110
      %00011110
      %01111110
end

  if joy0up then player0y = player0y - 1
  if joy0down then player0y = player0y + 1
  if joy0fire then reboot

  


 goto mainloop



 player0x = 1 
 player0y = 20
 
 rem I did end up writing out a lot of code, like the press fire to skip because I have no clue to make a 'lose health/points' and no added items, due to my lack of knowledge there too
 rem Contact ProwoodStuff#0317 on Discord if you have a solution to that issue, thanks lololol
 rem This was also originally 'Mini Amogus Adventure' before ultimately being changed to 'Halo Maze' as it sounds better, even if this is still trashy and has no actual correlation to Halo
