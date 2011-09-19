package com.syspeak.makereap.flowdesigner.ini18
{
	import flash.globalization.LocaleID;
	import flash.system.System;
	
	import mx.controls.Alert;
	import mx.resources.IResourceManager;
	import mx.resources.Locale;
	import mx.resources.ResourceBundle;
	import mx.resources.ResourceManager;

	/**
	 * 国际化资源载入类
	 * @company SysPeak (C) Copyright
	 * @author JemiZhuu(周士淳)
	 * @category Ini18ResourceLoader
	 * @version 1.0
	 * @since 2011-08-31
	 *
	 */
	[ResourceBundle("app_ini18")]
	[ResourceBundle("NodeListPanel")]
	public final class Ini18ResourceLoader {
		private static const APP_INI18:String = "app_ini18";
		private static const NODE_LIST_PANEL:String = "NodeListPanel";
		private static const resourceManager:IResourceManager = ResourceManager.getInstance();
		
		
		public static function getAppString(resourceName:String, parameters:Array=null):String {
			var locale:String = resourceManager.getPreferredLocaleChain()[0];
			return getString(APP_INI18, resourceName, parameters, locale);
		}
		
		public static function getLocaleString(bundleName:String, resourceName:String, parameters:Array=null):String {
			var locale:String = resourceManager.getPreferredLocaleChain()[0];
			return getString(bundleName, resourceName, parameters, locale);
		}
		
		/**
		 * 载入国际化字串
		 * @param String
		 * @param bundleName
		 * @param String
		 * @param resourceName
		 * @param parameters
		 * @param locale
		 * @return 
		 * 
		 */
		public static function getString(bundleName:String, resourceName:String, parameters:Array=null, locale:String=null):String {
			return resourceManager.getString(bundleName, resourceName, parameters, locale);
		}
		
	}
}