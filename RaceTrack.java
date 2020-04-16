public class RaceTrack {
 RaceCar[] cars;
 FinishLine finishline;
 PitStop pitstop;
 int numCars;
 int tickNum;
 /**
  * DO NOT REMOVE THIS - you should be using this to log this track's events in part B. For more see the assignment PDF / documentation for TrackLoggerA.java
  */
 // private TrackLoggerA logger;

 public RaceTrack() {
  // logger = new TrackLoggerA(); // DO NOT REMOVE THIS LINE
   this.finishline = new FinishLine();
   this.pitstop = new PitStop();
   this.numCars = 0;
   this.tickNum = 1;
   this.cars = new RaceCar[10];
 }
 
 public void setCars(RaceCar[] raceCars) {
   for(int i = 0; i<raceCars.length; i++) {
     cars[i]=raceCars[i];
   }
   this.numCars = raceCars.length;
 }
 
 //moves all the cars by their speed, checks for collision, and takes car out of race if it's finished
 public void tick() {
   System.out.println();
   System.out.println("Tick: " + tickNum);
   for(int i = 0; i < this.numCars; i++){
     if(cars[i].active && !cars[i].inPitStop){
       //checks if car passes finishline
       cars[i].totalUnits += cars[i].speed;
       if(cars[i].totalUnits >= 1000){
         finishline.enterFinishLine(cars[i]);
       }else{
         //updates the car's position
         int origPos = cars[i].position;
         cars[i].position += cars[i].speed;
         if(cars[i].damaged){
           if(origPos <75 && cars[i].position >= 75){
             pitstop.enterPitStop(cars[i]);
             System.out.println(cars[i] + " has entered pitstop.");
             cars[i].inPitStop = true;
           }
         }
         
         if(cars[i].position >= 100 ){
           cars[i].lap++;
           cars[i].position = cars[i].position - 100;
         }
       }
     } 
   }
   checkCollision(this.cars);
   pitstop.updateStatus();
   for(int i = 0; i < pitstop.carsInPitStop.length; i++){
     if(pitstop.carsInPitStop[i] != null){
       if(pitstop.carsInPitStop[i].psStatus > 2){
       pitstop.exitPitStop(pitstop.carsInPitStop[i]);
       pitstop.carsInPitStop[i] = null;
       }
     }
   }
       
   tickNum++;
 }
 
 //checks to see if any cars collided and if they did, it marks them as damaged and adjusts their speeds
 public void checkCollision(RaceCar[] car) {
   for(int i = 0; i < numCars; i++){
     for(int j = i+1; j <numCars; j++){
       if(car[i].active && car[j].active){
         if(car[i].position == car[j].position){
           if(!car[i].damaged){
             System.out.println(car[i] + " has been damaged.");
             car[i].speed = car[i].newSpeed;
             car[i].damaged = true;
           }
           if(!car[j].damaged){
             System.out.println(car[j] + " has been damaged.");
             car[j].speed = car[j].newSpeed;
             car[j].damaged = true;
           }
         }
       }
     }
   }

 }
 
 //executes the ticks to move cars
 public void run() {
   while(!finishline.finished(this.numCars)){
     tick();
   }
   System.out.println("You scored " + this.calculateScore() + " points.");
 }
 
 public int calculateScore() {
  //throw new UnsupportedOperationException("not implemented yet");
   return 1000 - (20*this.tickNum) + (150*numCars);
 }
 
 /**
  * Needed for part B
  * This method returns the logger instance used by this RaceTrack. You <b>SHOULD NOT</b> be using this method. 
  * @return logger with this track's events 
  */
 /*
 public TrackLoggerA getLogger() {
  return logger;
 }
 */
}
