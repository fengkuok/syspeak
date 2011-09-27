package com.syspeak.modules.web.springmvc;

import com.syspeak.modules.web.json.Page;
import com.syspeak.modules.web.json.JsonWriteBean;
//4.Privilege(权限，表示对Resource的一个操作，即Operation+Resource)
//[例如:/students+POST(创建)/GET(获取所有),/student/{id} GET(获取id={id})/PUT(更新)/DELETE(删除)]
//
//
//-----------------
//AbstractController{
//index      /student+GET
//show       /student/{id} GET
//new        /student/new GET
//edit       /student/{id}/edit GET
//create     /student+POST
//update     /student/{id}+PUT
//destory    /student/{id}+DELETE
//}
/**
 * 
 * @author GuoFeng
 *
 */
public abstract class AbstractJsonController<T> {


	
	/**
	 * 分页获取所有对象 
	 * url ：/student+GET
	 * @return
	 */
	public abstract Page<T> index();
	
	/**
	 * 根据Id获取对象
	 *  /student/{id} GET
	 * @param id pk
	 * @return
	 */
	public JsonWriteBean show(Long id){
		return null;
	}
	
	/**
	 * 新建
	 * 
	 * @return JsonWriteBean
	 */
	public JsonWriteBean neww(){
		return null;
	}
	
	/**
	 * /student/{id}/edit GET
	 * @param id
	 * @return
	 */
	public JsonWriteBean edit(Long id){
		return null;
	}
	
	/**
	 * /student+POST
	 * @param entity
	 * @return
	 */
	public JsonWriteBean create(T entity){
		return null;
	}
	
	/**
	 * /student/{id}+PUT
	 * @param id
	 * @param entity
	 * @return
	 */
	public JsonWriteBean update(Long id, T entity){
		return null;
	}
	
	/**
	 * /student/{id}+DELETE
	 * @param id
	 * @return
	 */
	public JsonWriteBean destory(Long id){
		return null;
	}
}
