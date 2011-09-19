package com.syspeak.makereap.flowdesigner.component.event
{
	import flash.display.Graphics;
	
	/**
	 * Start Event Component
	 * @company SysPeak (C) Copyright
	 * @author JemiZhuu(周士淳)
	 * @category StartEventComponent
	 * @version 1.0
	 * @since 2011-09-04
	 *
	 */
	public class EndEventComponent extends BaseEventComponent {
						
		private static const DEFAULT_RADIUS:int = 20;
		
		
		override protected function initUI():void {
			if(this.width==0) {
				this.width = DEFAULT_RADIUS;
				this.height = DEFAULT_RADIUS;
			}
			var g:Graphics = this.graphics;
			g.lineStyle(2);
			g.drawCircle(0, 0, width);
			g.beginFill(0xff0000);
			g.drawCircle(0, 0, width-2);
			g.endFill();
		}
		
		/**
		 *  @private
		 */
		override protected function measure():void {
			super.measure();			 
			measuredWidth = DEFAULT_RADIUS;
			measuredHeight = DEFAULT_RADIUS;
		}
	}
}