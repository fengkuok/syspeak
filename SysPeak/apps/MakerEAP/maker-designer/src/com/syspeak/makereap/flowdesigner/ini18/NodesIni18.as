package com.syspeak.makereap.flowdesigner.ini18
{
	import mx.managers.ISystemManager;
	import mx.resources.IResourceManager;
	import mx.resources.ResourceManager;

	/**
	 * 流程Node Component基类
	 * @company SysPeak (C) Copyright
	 * @author JemiZhuu(周士淳)
	 * @category NodesIni18
	 * @version 1.0
	 * @since 2011-09-04
	 *
	 */
	[ResourceBundle("Nodes")]
	[Mixin]
	public final class NodesIni18
	{
		private static const BUNDLE_NAME:String = "Nodes";
		private static var resourceManager:IResourceManager;
		
		public static function init(systemManager:ISystemManager):void {
			resourceManager = ResourceManager.getInstance();	
		}
				
		public function NodesIni18() {
		}
		
		public static function getNodeName(nodeKey:String):String {
			return resourceManager.getString(BUNDLE_NAME, nodeKey);
		}
		
		public static function getNodeTip(nodeKey:String):String {
			return resourceManager.getString(BUNDLE_NAME, nodeKey+"Tip");
		}
	}
}