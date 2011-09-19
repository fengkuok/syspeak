package com.syspeak.makereap.flowdesigner.model.node.task
{
	import com.syspeak.makereap.flowdesigner.component.task.UserTaskComponent;

	/**
	 * User Task Node
	 * @company SysPeak (C) Copyright
	 * @author JemiZhuu(周士淳)
	 * @category UserTaskNode
	 * @version 1.0
	 * @since 2011-09-01
	 *
	 */
	public class UserTaskNode extends BaseTaskNode {
		
		override protected function initDatas():void {
			super.initDatas();
			this.component = new UserTaskComponent();
		}
	}
}