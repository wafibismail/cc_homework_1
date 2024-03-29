class Block {
	private char color;
	private ColorFactory colorFactory = new ColorFactory();
	private Block previousAdjacentBlock;
	private Block nextAdjacentBlock;

	public Block() {
		this.setRandomColor();
		this.previousAdjacentBlock = null;
		this.nextAdjacentBlock = null;
	}

	public Block(Block blockToBeAssignedAsPreviousAdjacent) {
		this.setRandomColor();
		this.connectPreviousAdjacentBlock(blockToBeAssignedAsPreviousAdjacent);
		this.nextAdjacentBlock = null;
	}

	public char getColor() {
		return this.color;
	}

	public Block getNextAdjacentBlock() {
		return this.nextAdjacentBlock;
	}

	public Block getPreviousAdjacentBlock() {
		return this.previousAdjacentBlock;
	}

	public Boolean hasAnyAdjacentColorMatch() {
		return this.hasMatchingColoredPreviousAdjacentBlock() || this.hasMatchingColoredNextAdjacentBlock();
	}

	public int getSizeOfSameColoredBlocksCluster() {
		int totalSize = 1
			+ this.getBackwardSizeOfColorCluster()
			+ this.getForwardSizeOfColorCluster();

		return totalSize;
	}

	public void demolish() {
		this.discardAllPreviousAdjacentSameColorBlocks();
		this.discardAllNextAdjacentSameColorBlocks();
		this.discardSelf();
	}

	public Block searchBothSidesAndGetMainBlock() {
		Block assumedMainBlock = this;
		if (this.hasPreviousAdjacentBlock()) {
			assumedMainBlock = this.previousAdjacentBlock.searchBackwardAndGetMainBlock();
		}
		else if (this.hasNextAdjacentBlock()) {
			assumedMainBlock = this.nextAdjacentBlock;
		}
		return assumedMainBlock;
	}

	public void takePlaceOf(Block blockToBeReplaced) {
		this.takePreviousAdjacentConnectionFrom(blockToBeReplaced);
		this.takeNextAdjacentConnectionFrom(blockToBeReplaced);
	}

	public void insertBefore(Block blockToBeAssignedAsNextAdjacent) {
		this.takePreviousAdjacentConnectionFrom(blockToBeAssignedAsNextAdjacent);
		this.connectNextAdjacentBlock(blockToBeAssignedAsNextAdjacent);
	}

	private int getBackwardSizeOfColorCluster() {
		int count = 0;

		if (this.hasMatchingColoredPreviousAdjacentBlock()) {
			count = this.getPreviousAdjacentBlock().getBackwardSizeOfColorCluster() + 1;
		}

		return count;
	}

	private int getForwardSizeOfColorCluster() {
		int count = 0;

		if (this.hasMatchingColoredNextAdjacentBlock()) {
			count = this.getNextAdjacentBlock().getForwardSizeOfColorCluster() + 1;
		}

		return count;
	}

	private void discardAllPreviousAdjacentSameColorBlocks() {
		while (this.hasMatchingColoredPreviousAdjacentBlock()) {
			this.takePreviousAdjacentConnectionFrom(this.previousAdjacentBlock);
		}
	}

	private void discardAllNextAdjacentSameColorBlocks() {
		while (this.hasMatchingColoredNextAdjacentBlock()) {
			this.takeNextAdjacentConnectionFrom(this.nextAdjacentBlock);
		}
	}

	private void discardSelf() {
		if (this.hasPreviousAdjacentBlock()) {
			this.previousAdjacentBlock.takeNextAdjacentConnectionFrom(this);
		}
		else if (this.hasNextAdjacentBlock()) {
			this.nextAdjacentBlock.previousAdjacentBlock = null;
		}
	}

	private Block searchBackwardAndGetMainBlock() {
		Block assumedMainBlock = this;
		if (this.hasPreviousAdjacentBlock()) {
			assumedMainBlock = this.previousAdjacentBlock.searchBackwardAndGetMainBlock();
		}
		return assumedMainBlock;
	}

	private void takePreviousAdjacentConnectionFrom(Block blockToTakeConnectionFrom) {
		if (blockToTakeConnectionFrom.hasPreviousAdjacentBlock()) {
			Block newPreviousAdjacentBlock = blockToTakeConnectionFrom.getPreviousAdjacentBlock();

			this.connectPreviousAdjacentBlock(newPreviousAdjacentBlock);
		}
		else this.previousAdjacentBlock = null;
	}

	private void takeNextAdjacentConnectionFrom(Block blockToTakeConnectionFrom) {
		if (blockToTakeConnectionFrom.hasNextAdjacentBlock()) {
			Block newNextAdjacentBlock = blockToTakeConnectionFrom.getNextAdjacentBlock();

			this.connectNextAdjacentBlock(newNextAdjacentBlock);
		}
		else this.nextAdjacentBlock = null;
	}

	private void connectPreviousAdjacentBlock(Block blockToBeAssignedToPreviousAdjacent) {
		this.setPreviousAdjacentBlock(blockToBeAssignedToPreviousAdjacent);
		blockToBeAssignedToPreviousAdjacent.setNextAdjacentBlock(this);
	}

	private void connectNextAdjacentBlock(Block blockToBeAssignedToNextAdjacent) {
		this.setNextAdjacentBlock(blockToBeAssignedToNextAdjacent);
		blockToBeAssignedToNextAdjacent.setPreviousAdjacentBlock(this);
	}

	private Boolean hasMatchingColoredPreviousAdjacentBlock() {
		return this.hasPreviousAdjacentBlock() && this.previousAdjacentBlock.hasMatchingColorWith(this);
	}

	private Boolean hasMatchingColoredNextAdjacentBlock() {
		return this.hasNextAdjacentBlock() && this.nextAdjacentBlock.hasMatchingColorWith(this);
	}

	private Boolean hasMatchingColorWith(Block blockToBeComparedWith) {
		return this.color == blockToBeComparedWith.getColor();
	}

	private Boolean hasPreviousAdjacentBlock() {
		return this.previousAdjacentBlock != null;
	}

	private Boolean hasNextAdjacentBlock() {
		return this.nextAdjacentBlock != null;
	}
	
	private void setRandomColor() {
        this.color = colorFactory.getRandomColor();
	}

	private void setPreviousAdjacentBlock(Block blockToSetInPreviousPosition) {
		this.previousAdjacentBlock = blockToSetInPreviousPosition;
	}

	private void setNextAdjacentBlock(Block blockToSetInNextPosition) {
		this.nextAdjacentBlock = blockToSetInNextPosition;
	}
}

class ColorFactory {
    private char [] validColors = {'Y','R','G'};
    
    public char getRandomColor() {
        return validColors[getRandomColorIndex()];
    }

    private int getRandomColorIndex() {
        return (int) (Math.random() * getTotalValidColors());
    }

    private int getTotalValidColors() {
        return validColors.length;
    }
    
}
