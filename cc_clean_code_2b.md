## Part 2b - More problems related to functions

Applied recommendations include:
- Arguments are input arguments
- One input argument at most. If not then two at most. Implement argument object where appropriate
- Arrange code from most abstract to least abstract, top to down

```javascript
function createNewCalendar() {
    var segmentationInfo = {
        numberOfFillColumnSegments : DAYS_PER_WEEK,
        numberOfGapColumnSegments : (DAYS_PER_WEEK
                                    + canvasBorderOffset),
        numberOfFillRowSegments : (WEEKS_PER_MONTH
                                    + monthTextOffset
                                    + weekdayTextFillOffset),
        numberOfGapRowSegments : (WEEKS_PER_MONTH
                                    + canvasBorderOffset 
                                    + monthTextOffset 
                                    + weekdayTextGapOffset
        )
    };
    var ctx = initializeAndReturnNewCanvasCtx(segmentationInfo);
    var pencil = initializeAndGetNewPencilStartingPoint();
    drawCalendarWith(ctx,pencil);
}
function initializeAndReturnNewCanvasCtx(segmentationInfo) {
    canvas = document.createElement("canvas");
    canvas.classList.add("canvas","overlay-content");
    workspaceOverlay.appendChild(canvas);
    var canvasDimensions = getMaximumCanvasDimensions();
    canvas.width = carnvasDimensions.width;
    canvas.height = canvasDimensions.height;
    var segmentationDimensions = getSegmentationDimensionsBasedOn(segmentationInfo);
    var contextCreationArguments = {
        canvas: canvas,
        segmentatinDimensions: segmentationDimensions
        };
    ctx = initializeAndReturnContext(contextCreationArguments);
    return ctx
}
function initializeAndGetNewPencilStartingPoint(gapWidth){
    var pencilBorderOffset = bordersImplemented ? gapWidth : 0;
    var pencilX = 0 + pencilBorderOffset;
    var pencilY = 0 + pencilBorderOffset;
    return {pencilX, pencilY};
}
function setMaximumCanvasDimensions() {
    return {
        width : Math.min(
            maxCalendarWidthPixel,
            window.innerWidth * maxCalendarToWindowWidthRatio
            ),
        height : Math.min(
            canvas.width * maxCalendarHeightToOwnWidthRatio,
            window.innerHeight * maxCalendarToWindowWidthRatio
            )
    };
}
function getSegmentationDimensionsBasedOn(segmentationInfo) {
    return {
        fillWidth : 1 / segmentationInfo.numberOfFillColumnSegments * (horizontalFillToGapRatio) * canvas.width,
        gapWidth : 1 / segmentationInfo.numberOfGapColumnSegments * (1 - horizontalFillToGapRatio) * canvas.width,
        fillHeight : 1 / segmentationInfo.numberOfFillRowSegments * (verticalFillToGapRatio) * canvas.height,
        gapHeight : 1 / segmentationInfo.numberOfGapRowSegments * (1- verticalFillToGapRatio) * canvas.height
    };
}

function initializeAndReturnContext(contextCreationParameters) {
    ctx = contextCreationArguments.canvas.getContext("2d");
    var gapWidth = contextCreationArguments.gapWidth;
    var gapHeight = contextCreationArguments.gapHeight;
    noShadowColor = ctx.shadowColor;
    ctx.shadowBlur = gapWidth/2;
    ctx.shadowOffsetX = gapWidth/2;
    ctx.shadowOffsetY = gapHeight/2;
    ctx.textBaseline = 'middle';
    ctx.textAlign = 'center';
    return ctx;
}
```