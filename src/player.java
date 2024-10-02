public class player {
    private int healthPoint = 100;
    coords cord = new coords();

    protected class coords{
        private float posY=0;
        private float posX=0;

        coords(){
            this.posX = 0;
            this.posY = 0;
        }
        coords(float x,float y){
            this.posX = x;
            this.posY = y;
        }

        public float getPosX() {
            return posX;
        }

        public void setPosX(float posX) {
            this.posX = posX;
        }

        public float getPosY() {
            return posY;
        }

        public void setPosY(float posY) {
            this.posY = posY;
        }
    }

}
