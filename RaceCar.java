public class RaceCar {
  int speed;
  int strength;
  int lap;
  int position;
  int totalUnits;
  int newSpeed;
  int origSpeed;
  boolean active;
  boolean damaged;
  boolean inPitStop;
  int psStatus;
  
 public RaceCar(int speed, int strength) {
   this.lap = 1;
   this.position = 0;
   this.totalUnits = 0;
   this.newSpeed = speed-(strength*5);
   this.active = true;
   this.damaged = false;
   this.inPitStop = false;
   this.psStatus = 0;
   
   if(speed < 30){
     this.speed = 30;
     this.origSpeed = 30;
   }else if(speed > 55){
     this.speed = 55;
     this.origSpeed = 55;
   }else{
     this.speed = speed;
     this.origSpeed = speed;
   }
   
   if(strength < 2){
     this.strength = 2;
   }else if(strength > 4){
     this.strength = 4;
   }else{
     this.strength = strength;
   }
   System.out.println("Speed: " + origSpeed);
   System.out.println("Strength: " + strength);
 }
 
 public RaceCar() {
   this.speed = 40;
   this.strength = 3;
   this.lap = 1;
   this.position = 0;
   this.totalUnits = 0;
   this.newSpeed = 0;
   this.origSpeed = 40;
   this.active = true;
   this.damaged = false;
   this.inPitStop = false;
   this.psStatus = 0;
 }
 
 public int getLocation() {
  //throw new UnsupportedOperationException("not implemented yet");
   return (lap*100)+position;
 }
 
 public String toString() {
  //throw new UnsupportedOperationException("not implemented yet");
   return "RaceCar" + origSpeed + "/"+strength;
 }
}
