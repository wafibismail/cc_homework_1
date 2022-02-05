## Part 2b - More problems related to functions

### Source code

```javascript
function initializeAndReturnNewCanvasCtx(numberOfFillColumnSegments, numberOfGapColumnSegments, numberOfFillRowSegments, numberOfGapRowSegments) {
    canvas = document.createElement("canvas");
    canvas.classList.add("canvas","overlay-content");
    workspaceOverlay.appendChild(canvas);
    setMaximumCanvasDimensions(canvas);
    var fillWidth, gapWidth, fillHeight, gapHeight;
    setGapAndFillDimensions(fillWidth, gapWidth, fillHeight, gapHeight, numberOfFillColumnSegments, numberOfGapColumnSegments, numberOfFillRowSegments, numberOfGapRowSegments);
    
    ctx = initializeAndReturnCanvasContext(fillWidth, gapWidth, fillHeight, gapHeight);
    return ctx
}
function setGapAndFillDimensins(fillWidth, gapWidth, fillHeight, gapHeight) {
    fillWidth = 1 / numberOfFillColumnSegments * (horizontalFillToGapRatio) * canvas.width;
    gapWidth = 1 / numberOfGapColumnSegments * (1 - horizontalFillToGapRatio) * canvas.width;
    fillHeight = 1 / numberOfFillRowSegments * (verticalFillToGapRatio) * canvas.height;
    gapHeight = 1 / numberOfGapRowSegments * (1- verticalFillToGapRatio) * canvas.height;
}
function setMaximumCanvasDimensions(canvas) {
    canvas.width = Math.min(
        maxCalendarWidthPixel,
        window.innerWidth * maxCalendarToWindowWidthRatio
    );

    canvas.height = Math.min(
        canvas.width * maxCalendarHeightToOwnWidthRatio,
        window.innerHeight * maxCalendarToWindowWidthRatio
    );
}
function createNewCalendar() {
    var numberOfFillColumnSegments = DAYS_PER_WEEK;
    var numberOfGapColumnSegments = (DAYS_PER_WEEK + canvasBorderOffset);
    var numberOfFillRowSegments = (
        WEEKS_PER_MONTH
        + monthTextOffset
        + weekdayTextFillOffset
        );
    var numberOfGapRowSegments = (
        WEEKS_PER_MONTH
        + canvasBorderOffset 
        + monthTextOffset 
        + weekdayTextGapOffset
        );
    var ctx = initializeAndReturnNewCanvasCtx(numberOfFillColumnSegments, numberOfGapColumnSegments,
    numberOfFillRowSegments, numberOfGapRowSegments);
    var pencil = initializeAndGetNewPencilStartingPoint();
    drawCalendarWith(ctx);
}
function initializeCanvasContext(canvas) {
    ctx = canvas.getContext("2d");
    noShadowColor = ctx.shadowColor;
    ctx.shadowBlur = gapWidth/2;
    ctx.shadowOffsetX = gapWidth/2;
    ctx.shadowOffsetY = gapHeight/2;
    ctx.textBaseline = 'middle';
    ctx.textAlign = 'center';
    return ctx;
}
function initializeAndGetNewPencilStartingPoint(gapWidth){
    var pencilBorderOffset = bordersImplemented ? gapWidth : 0;
    var pencilX = 0 + pencilBorderOffset;
    var pencilY = 0 + pencilBorderOffset;
    return {pencilX, pencilY};
}
```

### Problems:
- Some of the functions' arguments are not input arguments. The values such as setGapAndFillDimensions(fillWidth, gapWidth, fillHeight, gapHeight, numberOfFillColumnSegments, numberOfGapColumnSegments, numberOfFillRowSegments, numberOfGapRowSegments) that is actually meant to assign values to the variables fillWidth, gapWidth, fillHeight, gapHeight.
- In addition, the above function has way too many arguments. The actual required arguments are the numberOf**Segments variables, which as they can be considered as one concept can just be passed in the form of one object.
- Code not arranged properly top to down by levels of abstraction
