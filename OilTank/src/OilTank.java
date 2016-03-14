import be.kuleuven.cs.som.annotate.Basic;
import be.kuleuven.cs.som.annotate.Immutable;

/**
 * A class of oil tanks.
 * 
 * @invar ...
 * 		  | isValidContent(this.getContent(), this.getcapacity())
 * @invar ...
 * 		  | isValidCapacity(this.getCapacity())
 * @author Alexander
 *
 */
public class OilTank {
	
	/**
	 * 
	 * @param content
	 * @param capacity
	 * @pre	  ...
	 * 		  | (content >= 0) && (content <= capacity)
	 * 		  | isValidContent(content)
	 * @pre   ...
	 * 		  | isValidCapacity(capacity)
	 * @post  ...
	 * 		  | new.getCapacity() == capacity
	 * @post  ...
	 * 		  | new.getContent() == content
	 */

	public OilTank(int content, int capacity){
		assert isValidCapacity(capacity);
		assert (content >= 0) && (content <= capacity);
		this.content = content;
		this.capacity = capacity;
		
	}
	
	/**
	 * Returns the amount of oil in this oil tank.
	 * @return
	 */
	@Basic
	public int getContent(){
		return this.content;		
	}
	
	/**
	 * 
	 * @param content
	 * @param capacity
	 * @return	...
	 * 			| result == (content >= 0)&& (content <= capacity)
	 */
	public static boolean isValidContent(int content, int capacity){
		return ((content >= 0) && (content <= capacity));
		
	}
	
	/**
	 * 
	 * @param	content
	 * @pre		...
	 * 		 	| isValidContent(content, this.getCapacity())
	 * @post 	...
	 * 		  	| new.getContent() == content
	 */
	public void setContent(int content){
		assert isValidContent(content, this.getCapacity());
		this.content = content;
	}
	
	private int content;
	
	@Basic @Immutable
	public int getCapacity(){
		return this.getCapacity();
	}
	/**
	 * 
	 * @param capacity
	 * @return  ...
	 * 			| if (capacity > 0)
	 * 			| 	then result == true
	 * 			| 	else result == False
	 */
	public static boolean isValidCapacity(int capacity) {
		return (capacity > 0);
		
	}
	
	private final int capacity;
	/**
	 * Fill this tank completely.
	 * 
	 * @post	...
	 * 			| new.getContent () == this.getCapacity()
	 */
	public void fillTank(){
		this.setContent(this.getCapacity());
	}
	/**
	 * Fill the tank with a given amount.
	 * @pre		...
	 * 			| amount > 0
	 * @pre		...
	 * 			| isValidContent(this.getContent() + amount, this.getCapacity())
	 * @post	...
	 * 			| new.getContent() == this.getContent()+ given amount
	 * @param amount
	 */
	public void addOil(int amount){
		assert amount > 0;
		this.setContent(this.getContent()+ amount);
	}
	
	/**
	 * 
	 * @param amounts
	 * @pre 	...
	 * 			| amount != null
	 * @pre		...
	 * 			| for each amount in amounts:
	 * 			|	amount > 0
	 * @pre 	...
	 * 			| isValidContent(this.getContent() + sum(amounts), this.getCapacity())
	 * @post 	...
	 * 			| new.getContent() == this.getContent() + sum(amounts)
	 */
	public void fillTank(int... amounts){
		assert amounts != null;
		for (int amount: amounts)
			this.addOil(amount);
	}
	
}
