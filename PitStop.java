public class PitStop {
  RaceCar[] carsInPitStop;
  int psPointer;
  
  public PitStop(){
    this.carsInPitStop = new RaceCar[10];
    this.psPointer = 0;
  }
  
 public void enterPitStop(RaceCar car) { // TODO you can add parameters here!
   if(this.psPointer == this.carsInPitStop.length){
     this.carsInPitStop = expand(this.carsInPitStop);
   }
   carsInPitStop[psPointer++] = car;
 }
 
 public void updateStatus(){
   for(int i = 0; i < carsInPitStop.length; i++){
     if(carsInPitStop[i] != null){
       carsInPitStop[i].psStatus++;
     }
   }
 }
 
 public void exitPitStop(RaceCar car){
    car.damaged = false;
    car.inPitStop = false;
    car.speed = car.origSpeed;
    car.psStatus = 0;
    System.out.println(car + " has left the pitstop.");
 }
 
 public static RaceCar[] expand(RaceCar[] carsInPitStop){
   RaceCar[] newArray = new RaceCar[carsInPitStop.length + 5];
   for(int i = 0; i < carsInPitStop.length; i++){
     newArray[i] = carsInPitStop[i];
   }
   return newArray;
 }
}
