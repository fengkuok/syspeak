package com.syspeak.makereap.flowdesigner.component.task
{
	import com.syspeak.makereap.flowdesigner.component.BaseNodeComponent;
	
	import flash.display.Bitmap;
	import flash.geom.Matrix;
	import flash.text.TextField;
	
	import mx.controls.Label;
	
	/**
	 * Base Task Node Component
	 * @company SysPeak (C) Copyright
	 * @author JemiZhuu(周士淳)
	 * @category BaseTaskComponent
	 * @version 1.0
	 * @since 2011-09-13
	 *
	 */	
	public class BaseTaskComponent extends BaseNodeComponent {
				
		[Embed(source="assets/icons/node/type.user.png")]
		protected static const ICON:Class;
		protected var _width:int = 105;
		protected var _height:int = 60;
		protected var _borderColor:uint = 0;
		protected var _ellipse:Number = 20;
		
		override protected function initDatas():void {
			super.initDatas();
			this._colors = [0xffffff, 0xffff9f, 0xfeec70, 0xf7cc2f];
			this._alphas = [1, 1, 1, 1];
			this._ratios = [100, 175, 225, 255];
			this._matrix = new Matrix();
			_matrix.createGradientBox(_width, _height, Math.PI/2);
		}
				
		protected var _matrix:Matrix;
		protected var _colors:Array;
		protected var _alphas:Array;
		protected var _ratios:Array;
		protected var icon:Bitmap;
		protected var textLb:TextField;
	}
}