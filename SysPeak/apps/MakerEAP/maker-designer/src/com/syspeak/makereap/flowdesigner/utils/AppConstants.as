package com.syspeak.makereap.flowdesigner.utils
{
	import mx.effects.Resize;
	import mx.resources.ResourceManager;

	public final class AppConstants
	{
		public function AppConstants()
		{
		}
		
		private static var _LOCALE:String = ResourceManager.getInstance().localeChain[0];
		
		
		public static function get locale():String {
			return _LOCALE;
		}

		public static function set locale(value:String):void {
			_LOCALE = value;
		}

	}
}