package de.dhbwka.java.exercise.classes;

public class Radio {
    
    private boolean on;
    private int volume;
    private double frequency;    
    
    public static void main(String[] args) {
        Radio radio = new Radio(false, 7, 93.5);
        System.out.println(radio);
        radio.turnOn();
        System.out.println(radio);
        radio.incVolume(); radio.incVolume();
        System.out.println(radio);
        radio.incVolume();
        radio.incVolume();
        System.out.println(radio);
        radio.decVolume();
        System.out.println(radio);
        radio.setFrequency(97.8);
        System.out.println(radio);
        radio.setFrequency(112.7);
        System.out.println(radio);
        radio.turnOff();
        System.out.println(radio);
        }
    
        public Radio(){
           this(true, 3, 99.9);
        }
        
        public Radio(boolean on, int volume, double frequency){
            this.on = on;
            setVolume(volume);
            setFrequency(frequency);
        }

        public void turnOn(){
            this.on = true;
        }
        public void turnOff(){
            this.on = false;
        }
        public int getVolume(){
            return volume;
        }
        public void setVolume(int volume){
            if(volume >= 0 && volume <= 10){
                this.volume = volume;
            }
        }
        public void incVolume(){
            setVolume(getVolume()+1);
        }
        public void decVolume(){
            setVolume(getVolume()-1);
        }
        public double getFrequency(){
            return frequency;
        }
        public void setFrequency(double frequency){
            if(frequency >= 85 && frequency <= 110){
                this.frequency = frequency;
            }else{
                this.frequency = 99.9;
            }
        }
        public String toString(){
            return String.format("Radio %s: Vol=" + getVolume() + ", Freq=" + getFrequency(), on ? "an": "aus");
        }
}
