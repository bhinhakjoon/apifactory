<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <form id="apiForm" action="/api/save" method="POST">
    
   id: <input type="text" name="id" />
   title:<input type="text" name="title" />
    
    <input type="button" onclick="apiForm.submit()" value="save"/>
    </form>