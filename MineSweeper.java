package com.MineSweeper;

public class MineSweeper {
    private int sizeGrid=9;
    private int [][] flowerGrid = new int[sizeGrid][sizeGrid];
    private int numBomb=6;
    private int [][] bombCoordinate =new int [numBomb][2];
    private int bombInserted=0;
    private int numbOfTurn=sizeGrid*sizeGrid-numBomb;


    public void addBomb(int x, int y)throws Exception{
        if(x<0|| x>this.flowerGrid.length || y<0 || y>this.flowerGrid.length) throw new Exception ("Invalid coordinate");
        if (numBomb==0){
            System.out.println("You finished the bomb");
            return;
        }
        this.flowerGrid[x][y]=8;
        this.bombCoordinate[bombInserted][0]=x;
            this.bombCoordinate[bombInserted][1]=y;
        --numBomb;
        ++bombInserted;
    }

    @Override
    public String toString() {
        String test="MY BOMB COORDINATES\n";

        for(int i=0; i<bombCoordinate.length;i++){
            for(int j=0; j<bombCoordinate[i].length;j++){
                test+="| " + bombCoordinate[i][j] + " |";
            }
            test+="\n";
        }

        test+="MINESWEEPER TABLE\n";
        for(int i=0; i<flowerGrid.length;i++){
            for(int j=0; j<flowerGrid[i].length;j++){
                test+="| "+ flowerGrid[i][j] + " |";
            }
            test+="\n";
        }
        return test;
    }

    public void addIndicator(){
        for(int i=0;i<6;i++){
            int coordinateX=bombCoordinate[i][0];
            int coordinateY= bombCoordinate[i][1];
                if(this.bombCoordinate[i][0]==0){
                    if(this.bombCoordinate[i][1]==0){
                        if(this.flowerGrid[0][1]!=8)this.flowerGrid[0][1]++;
                        if(this.flowerGrid[1][0]!=8)this.flowerGrid[1][0]++;
                        if(this.flowerGrid[1][1]!=8)this.flowerGrid[1][1]++;

                    }
                    else if(this.bombCoordinate[i][1]==8){
                        if(this.flowerGrid[0][7]!=8)this.flowerGrid[0][7]++;
                        if(this.flowerGrid[1][7]!=8)this.flowerGrid[1][7]++;
                        if(this.flowerGrid[1][8]!=8)this.flowerGrid[1][8]++;
                    }
                    else {
                        if(this.flowerGrid[coordinateX][coordinateY-1]!=8)this.flowerGrid[coordinateX][coordinateY-1]++;
                        if(this.flowerGrid[coordinateX+1][coordinateY-1]!=8)this.flowerGrid[coordinateX+1][coordinateY-1]++;
                        if(this.flowerGrid[coordinateX+1][coordinateY]!=8)this.flowerGrid[coordinateX+1][coordinateY]++;
                        if(this.flowerGrid[coordinateX+1][coordinateY+1]!=8)this.flowerGrid[coordinateX+1][coordinateY+1]++;
                        if(this.flowerGrid[coordinateX][coordinateY+1]!=8)this.flowerGrid[coordinateX][coordinateY+1]++;
                    }
                }
                else if(this.bombCoordinate[i][0]==8){
                        if(this.bombCoordinate[i][1]==0){
                            if(this.flowerGrid[7][0]!=8)this.flowerGrid[7][0]++;
                            if(this.flowerGrid[7][1]!=8)this.flowerGrid[7][1]++;
                            if(this.flowerGrid[8][1]!=8)this.flowerGrid[8][1]++;
                        }
                        else if(this.bombCoordinate[i][1]==8){
                            if(this.flowerGrid[8][7]!=8)this.flowerGrid[8][7]++;
                            if(this.flowerGrid[7][7]!=8)this.flowerGrid[7][7]++;
                            if(this.flowerGrid[7][8]!=8)this.flowerGrid[7][8]++;
                        }
                        else {
                            if(this.flowerGrid[coordinateX][coordinateY-1]!=8)this.flowerGrid[coordinateX][coordinateY-1]++;
                            if(this.flowerGrid[coordinateX-1][coordinateY-1]!=8)this.flowerGrid[coordinateX-1][coordinateY-1]++;
                            if(this.flowerGrid[coordinateX-1][coordinateY]!=8)this.flowerGrid[coordinateX-1][coordinateY]++;
                            if(this.flowerGrid[coordinateX-1][coordinateY+1]!=8)this.flowerGrid[coordinateX-1][coordinateY+1]++;
                            if(this.flowerGrid[coordinateX][coordinateY+1]!=8)this.flowerGrid[coordinateX][coordinateY+1]++;
                        }
                }
                else if(bombCoordinate[i][0]>0 && bombCoordinate[i][0]<8 && bombCoordinate[i][1]>0 && bombCoordinate[i][1]<8) {
                    if (this.flowerGrid[coordinateX - 1][coordinateY - 1] != 8)
                        this.flowerGrid[coordinateX - 1][coordinateY - 1]++;
                    if (this.flowerGrid[coordinateX][coordinateY - 1] != 8)
                        this.flowerGrid[coordinateX][coordinateY - 1]++;
                    if (this.flowerGrid[coordinateX + 1][coordinateY - 1] != 8)
                        this.flowerGrid[coordinateX + 1][coordinateY - 1]++;
                    if (this.flowerGrid[coordinateX + 1][coordinateY] != 8)
                        this.flowerGrid[coordinateX + 1][coordinateY]++;
                    if (this.flowerGrid[coordinateX + 1][coordinateY + 1] != 8)
                        this.flowerGrid[coordinateX + 1][coordinateY + 1]++;
                    if (this.flowerGrid[coordinateX][coordinateY + 1] != 8)
                        this.flowerGrid[coordinateX][coordinateY + 1]++;
                    if (this.flowerGrid[coordinateX - 1][coordinateY] != 8)
                        this.flowerGrid[coordinateX - 1][coordinateY + 1]++;
                    if (this.flowerGrid[coordinateX - 1][coordinateY] != 8)
                        this.flowerGrid[coordinateX - 1][coordinateY]++;
                }
        }
    }

    public String playTurn(int x, int y)throws Exception{
        if(x<0|| x>this.flowerGrid.length || y<0 || y>this.flowerGrid.length) throw new Exception ("Invalid coordinate");
        if(numbOfTurn==0) return "EMPTY SLOT FINISHED. YOU WIN :)";
        if( this.flowerGrid[x][y]==8) return " OPS. YOU CLICK ON MINE. GAME OVER";
        numbOfTurn--;
        return "";
    }
}
