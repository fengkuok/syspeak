package com.syspeak.makereap.flowdesigner.component.task
{
	import com.syspeak.makereap.flowdesigner.component.BaseNodeComponent;
	
	import flash.display.Bitmap;
	import flash.display.GradientType;
	import flash.text.TextField;
	
	import mx.controls.Label;
	
	/**
	 * User Task Component
	 * @company SysPeak (C) Copyright
	 * @author JemiZhuu(周士淳)
	 * @category UserTaskComponent
	 * @version 1.0
	 * @since 2011-09-13
	 *
	 */	
	public class UserTaskComponent extends BaseTaskComponent {
		
		override protected function initUI():void {
			super.initUI();
			this.mouseChildren = false;
			var left:Number = -_width/2;
			var top:Number = -_height/2;
			var icon:Bitmap = new ICON();
			addChild(icon);
			icon.x = left+5;
			icon.y = top+5;
			this.textLb = new TextField();
			textLb.text = this.nodeName;
			addChild(textLb);
			textLb.selectable=false;
			textLb.x = left+(_width-textLb.textWidth)/2;
			textLb.y = top+(_height-textLb.textHeight)/2;			
			graphics.lineStyle(1, _borderColor);
			graphics.drawRoundRect(left, top, _width, _height, _ellipse);
			_matrix.createGradientBox(_width, _height, Math.PI/2, left, top);
			graphics.beginGradientFill(GradientType.LINEAR, _colors, _alphas, _ratios, _matrix);
			graphics.drawRoundRect(left, top, _width, _height, _ellipse);
			graphics.endFill();
		}
	}
}