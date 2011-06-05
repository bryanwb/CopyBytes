package org.example.copystuff;

public class Stream<T>{
	public T str = null;
	
	public void add(T stream){
				this.str = stream;
	}
	public T get(){
		return this.str;
	}
	
}
