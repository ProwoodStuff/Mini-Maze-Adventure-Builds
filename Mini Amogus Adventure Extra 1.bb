 rem Game: Mini Amogus Adventure
 rem Console: Atari 2600
 rem Reigon: NTSC (North America)
 rem Year: 2022
 rem Month: December
 rem Date: 13th
 rem Day: Tuesday
 
 set romsize 8kSC
 set tv NTSC
 rem score = score + 1
  const noscore = 1
   const pfscore = 1
    pfscore1 = %00010101
     pfscorecolor = $2A
     pfscore1 = pfscore1/4


 rem if score = 0 then reboot
   
   
 playfield:
   ......................XXXXXXXXXX
   ......................X.........
   ....XXXXXXXXXX.........X........
   X...X........X....XXXXXXXXXX...X
   X...X........X..........X..X...X
   X...X...XXXXXX..........X..X...X
   X.......X.........XXXXXXX......X
   X.......X......................X
   X...XXXXX..XXXXXXXXXXX..XXXX...X
   X..............................X
   X..............................X
end
 scorecolor = 55
 PF0 = %10000000
 const pfrowheight=8


   missile0x =143
   missile0y = 24
   missile0height = 16


   player0:
   %0110011
   %0110011
   %0111111
   %01111111
   %01111110
   %01111110
   %01111111
   %0111111
end


 player0x = 1
 player0y = 20

 COLUPF = 10
 COLUBK = 110

mainloop
 drawscreen

  if collision(player0,playfield) then player0x = 1
  if collision(player0,playfield) then player0y = 20
  if collision(player0,missile0) then score = score + 1
  if collision(player0,missile0) then pfclear %10101010
  if collision(player0,missile0) then player0x = 1
  if collision(player0,missile0) then player0y = 20
  if collision(player0,missile0) then playfield:
   .............XXXXXXXXXXXXXXXXXXX
   .............X...........X......
   .............X...........X......
   X...XXXXXX...XXXXX...X..XXXX...X
   X........X...........X.........X
   X....XXXX........X...X....X....X
   X................X...X.....X...X
   XXXXXXXXXX..XXXXXX...XXXXXXX...X
   X...........X..............X...X
   X...........X..................X
   XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
end
  if collision(player0,missile0) then  COLUPF = 25
  if collision(player0,missile0) then  COLUBK = 220
  if collision(player0,missile0) then  missile0height = 0
  if collision(player0,missile0) then  missile0x = 0
  if collision(player0,missile0) then  missile0y = 0
  if collision(player0,missile0) then  missile1y = 24
  if collision(player0,missile0) then  missile1x = 142
  if collision(player0,missile0) then  missile1height = 16
  if collision(player0,missile1) then playfield:
   ...XXX...................XXXXXXX
   ...XXX...................X......
   ...XXX...................X......
   X..XXX.......XXXXXXX..XXXX...XXX
   X..XXX....XXXX.....X...........X
   X..XXX....X........X...........X
   X..XXX.............X.....X.....X
   X..XXXXX..XXXXXX...XXXXXXX.....X
   X.........X....................X
   X.........X....X...............X
   X..............................X
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
  
  
  if collision(player0,ball) then playfield:
   ................................
   X..............................X
   X.XXXXX.X....X.XXXXX.X.X.X.X.X.X
   X.X.....X....X.X.....X.X.X.X.X.X
   X.XXXXX.X....X.XXXXX.X.X.X.X.X.X
   X.....X.X....X.....X...........X
   X.XXXXX.XXXXXX.XXXXX.X.X.X.X.X.X
   X..............................X
   X..............................X
   X..............................X
   ................................
end




  if joy0right then player0x = player0x + 1
    if joy0right then player0:
   %0110011
   %0110011
   %0111111
   %01111111
   %01111110
   %01111110
   %01111111
   %0111111
end

  if joy0left then player0x = player0x - 1
    if joy0left then player0:
   %0110011
   %0110011
   %0111111
   %01111111
   %00011111
   %00011111
   %01111111
   %0111111
end

  if joy0up then player0y = player0y - 1
  if joy0down then player0y = player0y + 1
  if joy0fire then player0x = 115
  

  rem if pfscore1 = 0 then reboot

  rem if collision(player0,playfield) then pfscore1 = pfscore1/2
 

 goto mainloop


 player0x = 1 
 player0y = 20
 
 rem I did end up writing out a lot of code, like the press fire to skip because I have no clue to make a 'lose health/points' and no added items, due to my lack of knowledge there too
 rem Contact ProwoodStuff#0317 on Discord if you have a solution to that issue, thanks lololol

  inline 6lives.asm