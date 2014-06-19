package com.home.maxwell.service.impl.async;

import java.util.PriorityQueue;

public class BlockPriorityQueue<T> {
	protected PriorityQueue<T> queue = new PriorityQueue<T>(10);
	
	public BlockPriorityQueue(int no){
		queue = new PriorityQueue<T>(no);
	}
	
	public void push(T obj) {
		synchronized(queue) {
			queue.add(obj);
			queue.notify();
		}
	}
	
	public T pop() throws InterruptedException {
		synchronized(queue) {
			if (queue.isEmpty()){
				queue.wait();
			}
			
			return queue.poll();
		}
	}
	
	public int size(){
		return queue.size();
	}

	
	
}
