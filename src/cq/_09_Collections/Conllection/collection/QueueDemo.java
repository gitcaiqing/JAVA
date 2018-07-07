package cq._09_Collections.Conllection.collection;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class QueueDemo {

	public static void printQ(Queue queue) {
		while(queue.peek() != null) {
			System.out.println(queue.remove()+" ");
		}
	}
	
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<Integer>();
		Random random = new Random();
		for(int i = 0; i < 10; i++) {
			queue.offer(random.nextInt(i+10));
		}
		System.out.println(queue);
		printQ(queue);
		Queue<Character> qCharacters = new LinkedList<Character>();
		for(Character c:"Brontosarus".toCharArray()) {
			qCharacters.offer(c);
		}
		System.out.println(queue);
		printQ(qCharacters);
	}
}
