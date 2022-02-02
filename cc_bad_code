class Block {
	private char color;
	private char [] colorChoices = {'Y','R','G'};
	private Block prev;
	private Block next;

	public Block() {
		this.color = newColor();

		this.prev = null;
		this.next = null;
	}

	//To initialize blocks automatically appended to the end of the line-up
	//Accepts an already existing block as argument
	public Block(Block tail) {
		this.color = newColor();

		//The block is linked to the last block in the line-up (passed as argument)
		this.prev = tail;

		this.next = null;

		prev.next = this;
	}
	
	//Returns a random "color" character from the available colors
	private char newColor() {
		return colorChoices[(int) (Math.random()*colorChoices.length)];
	}

	public char getColor() {
		return this.color;
	}

	public Block getNext() {
		return this.next;
	}

	public Block getPrev() {
		return this.prev;
	}

	//Method to place current Block in an existing Block's place in the sequence of blocks
	//Returns an int value representing the amount of blocks to be demolished
	public int takePlace(Block old) {
		this.prev = old.prev;
		this.next = old.next;

		if (old.prev != null) old.prev.next = this;
		if (old.next != null) old.next.prev = this;

		int count = this.countSameColRight() + this.countSameColLeft();

		if (count > 0) return count + 1;

		//return 0 if no demolision would occur
		else return 0;
	}

	//Method to place current Block object between:
	//-the Block object passed as argument and
	//-the Block object referenced by the above Block's "prev" instance variable
	//Returns an int value representing amount of blocks to be demolished
	public int insertAt(Block old) {
		this.prev = old.prev;
		this.next = old;

		if (old.prev != null) old.prev.next = this;

		old.prev = this;

		int count = this.countSameColRight() + this.countSameColLeft();

		//return int value representing amount of blocks to be demolished
		if (count > 0) return count + 1;
		else return 0;

	}
	
	//Method to demolish adjacent blocks of the same colour
	//Returns the leftmost Block after demolition, i.e. "head"
	//that is, the only/main block that needs to be referenced in the main program	
	public Block demolish() {
		Block right = this.next;
		Block left = this.prev;

		//Whether at least any Block would be demolished
		Boolean demolished = false;

		for (int i = 0; i < this.countSameColRight(); i++) {
			right = right.next;
			if (!demolished) demolished = true;
		}

		for (int i = 0; i < this.countSameColLeft(); i++) {
			left = left.prev;
			if (!demolished) demolished = true;
		}

		Block head = this;
		if (demolished) {
			if (right != null) {
				right.prev = left;

				//Assign the right Block as head in case all blocks to its left are demolished
				head = right;
			}
			if (left != null) left.next = right;
			else if (right == null) return null;
			//if both left and right == null, that means no block remain in the sequence
		}

		while (head.prev != null) head = head.prev;

		//head would either be:
		//a) right if all blocks to its left is demolished
		//b) current head if some blocks still remain to the left of the demolished blocks
		//c) null if no blocks remain after demolition

		return head;
	}

	//Recursive method to check if blocks to the right are demolishable
	//Returns the number of blocks to be demolished
	private int countSameColRight() {
		//A counter for to-be-demolished blocks
		int count = 0;
		if (this.next != null && this.next.color == this.color)
			//amount returned will be 1 unit greater for every same color adjacent block to the right
			count = this.next.countSameColRight() + 1;
		return count;
	}

	//Recursive method to check if blocks to the left are demolishable
	//Returns the number of blocks to be demolished
	private int countSameColLeft() {
		//Number of blocks to be demolished
		int count = 0;
		if (this.prev !=null && this.prev.color == this.color)
			count = this.prev.countSameColLeft() + 1;
		return count;
	}

}
