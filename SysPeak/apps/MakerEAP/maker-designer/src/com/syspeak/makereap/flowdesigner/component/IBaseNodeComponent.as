package com.syspeak.makereap.flowdesigner.component
{
	internal interface IBaseNodeComponent {
		function moveTo(px:Number, py:Number):void;
		function destroy():void;
	}
}