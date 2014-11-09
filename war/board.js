
//Functions
			function initialize(){
                var canvas = document.getElementById("canvas_1");
                //Draws entire frame around box
                drawBigBoard();
                
                //ComplexBoard complex = new ComplexBoard();
                
                //Will draw the individual boards, indexed starting at 0 meaning left,top 2 meaning right bottom
                drawMiniBoardAtPosition(0,0);
                drawMiniBoardAtPosition(1,0);
                drawMiniBoardAtPosition(2,0);
                drawMiniBoardAtPosition(0,1);
                drawMiniBoardAtPosition(1,1);
                drawMiniBoardAtPosition(2,1);
                drawMiniBoardAtPosition(0,2);
                drawMiniBoardAtPosition(1,2);
                drawMiniBoardAtPosition(2,2);
    
				canvas.addEventListener("mousedown", doMouseDown, false);
			}
            
            //This registers the mouse listener
			function doMouseDown(event){
                var canvas = document.getElementById("canvas_1");
                var rect = canvas.getBoundingClientRect();
                
                //Used for math manipulation
                var starting_corner = 25;
                var bigboard_width = 150;
                var smallboard_width = 50;
                
				canvas_x = event.clientX - rect.left;
				canvas_y = event.clientY - rect.top;
				//alert("X=" + canvas_x + " Y=" + canvas_y);
                
                //Now we will check to see where the position was so that we can draw a rectangle
                canvas_x -= starting_corner; //This will make our division easier
                canvas_y -= starting_corner;
                
                //Now we know that canvas_x and canvas_y divided by 150 will give us what quadrant we are in
                quadrant_x = Math.floor(canvas_x/bigboard_width);   //We can use floor since only positive
                quadrant_y = Math.floor(canvas_y/bigboard_width);
                //alert("quad_X=" + quadrant_x + " quad_Y=" + quadrant_y);
                
                //Within the quadrant, we want to know the relative location. We can use mod to do this
                miniboardquadrant_x = Math.floor((canvas_x % bigboard_width) / smallboard_width);
                miniboardquadrant_y = Math.floor((canvas_y % bigboard_width) / smallboard_width);
                //alert("mini_X=" + miniboardquadrant_x + " mini_Y=" + miniboardquadrant_y);
                
                fillInMiniBoardInQuadrantAndPosition(quadrant_x,quadrant_y,miniboardquadrant_x,miniboardquadrant_y);
                
			}
            
            function drawBigBoard(){
                var canvas = document.getElementById("canvas_1");
                var ctx = canvas.getContext("2d");
            
                //Variables I create to draw board
                var starting_corner = 25;
                var ending_corner = 475;
                var bigboard_width = 150;
                var smallboard_width = 50;
                var smallboard_offset = 10;
                
                ctx.lineWidth = 5; //Make it a little bolder
                //Draw the entire frame of the box
                ctx.moveTo(starting_corner,starting_corner);
                ctx.lineTo(ending_corner,starting_corner);
                ctx.stroke();
                ctx.lineTo(ending_corner,ending_corner);
                ctx.stroke();
                ctx.lineTo(starting_corner,ending_corner);
                ctx.stroke();
                ctx.lineTo(starting_corner,starting_corner);
                ctx.stroke();

                //Draw the 2 big lines down the board, width is 150
                ctx.moveTo(starting_corner + bigboard_width, starting_corner);
                ctx.lineTo(starting_corner + bigboard_width, ending_corner);
                ctx.stroke();
                ctx.moveTo(starting_corner + 2 * bigboard_width, starting_corner);
                ctx.lineTo(starting_corner + 2 * bigboard_width, ending_corner);
                ctx.stroke();

                //Draw the 2 big lines across the board, width is 150
                ctx.moveTo(starting_corner, starting_corner  + bigboard_width);
                ctx.lineTo(ending_corner, starting_corner + bigboard_width);
                ctx.stroke();
                ctx.moveTo(starting_corner, starting_corner  + 2 * bigboard_width);
                ctx.lineTo(ending_corner, starting_corner + 2 * bigboard_width);
                ctx.stroke();
	       }
            
            	//We will break up the large board into 9 sections, top left corner is 0,0 and bottom right is 2,2
            function drawMiniBoardAtPosition(x, y){
            var c = document.getElementById("canvas_1");
            var ctx = c.getContext("2d");

            var starting_corner = 25;
            var ending_corner = 475;
            var bigboard_width = 150;
            var smallboard_width = 50;
            var smallboard_offset = 10;
                ctx.lineWidth = 1;
                //Draw the first smaller board in the upper, left corner
                ctx.moveTo(starting_corner + smallboard_width + (x * bigboard_width), 
                           starting_corner + smallboard_offset  + (y * bigboard_width));
                ctx.lineTo(starting_corner + smallboard_width + (x * bigboard_width), 
                           starting_corner + 3 * smallboard_width - smallboard_offset + (y * bigboard_width));
                ctx.stroke();
                ctx.moveTo(starting_corner + 2 * smallboard_width + (x * bigboard_width), 
                           starting_corner + smallboard_offset + (y * bigboard_width));
                ctx.lineTo(starting_corner + 2 * smallboard_width + (x * bigboard_width), 
                           starting_corner + 3 * smallboard_width - smallboard_offset + (y * bigboard_width));
                ctx.stroke();
                ctx.moveTo(starting_corner + smallboard_offset + (x * bigboard_width), 
                           starting_corner + smallboard_width + (y * bigboard_width));
                ctx.lineTo(starting_corner + 3 * smallboard_width - smallboard_offset + (x * bigboard_width), 
                           starting_corner + smallboard_width + (y * bigboard_width));
                ctx.stroke();
                ctx.moveTo(starting_corner + smallboard_offset + (x * bigboard_width), 
                           starting_corner + 2 * smallboard_width + (y * bigboard_width));
                ctx.lineTo(starting_corner + 3 * smallboard_width - smallboard_offset + (x * bigboard_width), 
                           starting_corner + 2 * smallboard_width + (y * bigboard_width));
                ctx.stroke();
	       }
            
            function fillInMiniBoardInQuadrantAndPosition(quadrant_x, quadrant_y, miniboard_x, miniboard_y)
            {
                var canvas = document.getElementById("canvas_1");
                var ctx = canvas.getContext("2d");
            
                //Variables I create to draw board
                var starting_corner = 25;
                var ending_corner = 475;
                var bigboard_width = 150;
                var smallboard_width = 50;
                var smallboard_offset = 10;
                var fill_offset = 5;
                
                //First, let's move to the right spot. We have the big board quadrant and little board quadrant
                fillInX = starting_corner + quadrant_x * bigboard_width + miniboard_x * smallboard_width;
                fillInY = starting_corner + quadrant_y * bigboard_width + miniboard_y * smallboard_width;
                ctx.fillStyle="#FF0000";    //makes the color red
                ctx.fillRect(fillInX + fill_offset,fillInY + fill_offset, smallboard_width - smallboard_offset, 
                             smallboard_width - smallboard_offset); 
            }           