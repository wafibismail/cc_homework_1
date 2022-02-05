## Part 2a - Some problems with functions

Applied recommendations include:
- Assigning verbs as method names
- Reducing the levels of abstractions to be least possible in the function(s)
- Eliminating "side effects" by initializing local variables to be used instead of changing global variables.

Note:
- Functions such as setGapAndFillDimensions() are not really applicable in this case since the variables passed as argument to it are not modified. This is just to demonstrate a further problem of too many arguments.

```javascript
function initializeAndReturnNewCanvasCtx(numberOfFillColumnSegments, numberOfGapColumnSebments, numberOfFillRowSegments, numberOfGapRowSegments) {
    canvas = document.createElement("canvas");
    canvas.classList.add("canvas","overlay-content");
    workspaceOverlay.appendChild(canvas);
    setMaximumCanvasDimensions(canvas);
    var fillWidth, gapWidth, fillHeight, gapHeight;
    setGapAndFillDimensions(fillWidth, gapWidth, fillHeight, gapHeight);
    ctx = initializeAndReturnCanvasContext(fillWidth, gapWidth, fillHeight, gapHeight);
    return ctx
}
function setGapAndFillDimensins(fillWidth, gapWidth, fillHeight, gapHeight) {
    fillWidth = 1 / numberOfFillColumnSegments * (horizontalFillToGapRatio) * canvas.width;
    gapWidth = 1 / numberOfGapColumnSebments * (1 - horizontalFillToGapRatio) * canvas.width;
    fillHeight = 1 / numberOfFillRowSegments * (verticalFillToGapRatio) * canvas.height;
    gapHeight = 1 / numberOfGapRowSegments * (1- verticalFillToGapRatio) * canvas.height;
}
function rescaleGapAndFillDimensins(fillWidth, gapWidth, fillHeight, gapHeight) {
    if (isGapWiderThanTall()) {
        gapWidth = gapHeight;
        horizontalFillToGapRatio = 1 - (gapWidth * (DAYS_PER_WEEK + canvasBorderOffset) / canvas.width);
        fillWidth = 1 / DAYS_PER_WEEK * (horizontalFillToGapRatio) * canvas.width;
    }
    else {
        gapHeight = gapWidth;
        verticalFillToGapRatio = 1 - (gapHeight * (WEEKS_PER_MONTH + canvasBorderOffset + monthTextOffset + weekdayTextGapOffset) / canvas.height);
        fillHeight = 1 / (WEEKS_PER_MONTH + monthTextOffset + weekdayTextGapOffset) * (verticalFillToGapRatio) * canvas.height;
    } 
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
    var numberOfGapColumnSebments = (DAYS_PER_WEEK + canvasBorderOffset);
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
    var ctx = initializeAndReturnNewCanvasCtx(numberOfFillColumnSegments, numberOfGapColumnSebments,
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