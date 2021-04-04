package dcp.DCP21;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/*
 * Heap related.
 * 
 * */
public class DCP21 {
	public int minMeetingRooms(List<Interval> intervals ){
		Collections.sort(intervals,(a,b)->Integer.compare(a.start, b.start));
		PriorityQueue<Integer> pq=new PriorityQueue<>();
		int roomCount=0;
		for(Interval interval:intervals){
			if(!pq.isEmpty() && interval.start>=pq.peek()){
				pq.poll();
			}else{
				roomCount++;
			}
			pq.add(interval.end);
		}
		return roomCount;
	}
	

	public static void main(String[] args) {
		
		DCP21 dcp21=new DCP21();
		List<Interval> intervals=new ArrayList<>();
		//tc1
		/*intervals.add(new Interval(2,15));
		intervals.add(new Interval(36,45));
		intervals.add(new Interval(9,29));
		intervals.add(new Interval(16,23));
		intervals.add(new Interval(4,9));*/
		//tc2
		intervals.add(new Interval(0,30));
		intervals.add(new Interval(5,10));
		intervals.add(new Interval(15,20));
        System.out.println("no of rooms :"+dcp21.minMeetingRooms(intervals) );
	}

}
class Interval{
	int start, end;
	public Interval(int start,int end){
		this.start=start;
		this.end=end;
	}
	
	public String toString(){
		return start+"--"+end;
	}
	
}
