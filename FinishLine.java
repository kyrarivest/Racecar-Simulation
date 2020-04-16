import java.util.*;
public class FinishLine {
  RaceCar[] finishedCars;
  int pointer;
  
  public FinishLine(){
    this.finishedCars = new RaceCar[10];
    this.pointer = 0;
  }

 public void enterFinishLine(RaceCar car) { // TODO you can add parameters here!
   this.finishedCars[pointer] = car;
   car.active = false;
   pointer++;
   System.out.println(car + " has finished in place " + pointer + ".");
  
 }
 
 public boolean finished(int numCars) {
  //throw new UnsupportedOperationException("not implemented yet");
   if(pointer == numCars){
     return true;
   }else{
     return false;
   }
 }
}

