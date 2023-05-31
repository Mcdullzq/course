<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>管理员后台</title>
    <link rel="stylesheet" href="${ctx}/resource/css/pintuer.css">
    <link rel="stylesheet" href="${ctx}/resource/css/admin.css">
    <script src="${ctx}/resource/js/jquery.js"></script>
    <script src="${ctx}/resource/js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel">
    <div class="panel-head" id="add">
        <strong><span class="icon-pencil-square-o">新增用户</span></strong>
    </div>
    <div class="body-content">
        <form action="${ctx}/user/exAdd" method="post" class="form-x">
            <div class="form-group">
                <div class="label"><label>用户名:</label></div>
                <div class="field">
                    <input type="text" class="input w50" name="userName" data-validate="required:请输入用户名"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label"><label>密码:</label></div>
                <div class="field">
                    <input type="text" class="input w50" name="passWord" data-validate="required:请输入密码"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label"><label>电话:</label></div>
                <div class="field">
                    <input type="text" class="input w50" name="phone" data-validate="required:请输入联系电话"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label"><label>真实姓名:</label></div>
                <div class="field">
                    <input type="text" class="input w50" name="realName" data-validate="required:请输入真实姓名"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label"><label>性别:</label></div>
                <div class="field">
                    <select name="sex" class="input w50">
                        <option value="女">女</option>
                        <option value="男">男</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <div class="label"><label>地址:</label></div>
                <div class="field">
                    <input type="text" class="input w50" name="address" data-validate="required:请输入地址"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label"><label>邮箱:</label></div>
                <div class="field">
                    <input type="text" class="input w50" name="email" data-validate="required:邮箱" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label"></div>
                <div class="field">
                    <button class="button bg-main icon-check-square-o" type="submit">新增</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>