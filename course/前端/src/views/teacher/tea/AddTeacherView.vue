<template>
	<div id="addTeaContainer">
		<el-form label-width="120px" size="large">
			<el-form-item label="教师姓名:">
				<el-input placeholder="请输入教师姓名" v-model="tea.teaName"></el-input>
			</el-form-item>
			<el-form-item label="教师性别:">
				<el-select v-model="tea.teaSex">
					<el-option label="男" value="1"></el-option>
					<el-option label="女" value="2"></el-option>
				</el-select>
			</el-form-item>
			<el-form-item label="教师邮箱:">
				<el-input placeholder="请输入教师邮箱" v-model="tea.teaEmail"></el-input>
			</el-form-item>
			<el-form-item label="教师身份:">
				<el-select v-model="tea.teaType">
					<el-option label="管理员" value="1"></el-option>
					<el-option label="教师" value="2"></el-option>
				</el-select>
			</el-form-item>
			<el-form-item>
				<el-button @click="doSave">保存</el-button>
			</el-form-item>
		</el-form>
	</div>
</template>

<script>
	export default{
		name:'AddTeacherView',
		data() {
			return{
				tea:{
					teaName:'',
					teaSex:'1',
					teaEmail:'',
					teaType:'2'
				}
			}
		},
		methods:{
			doSave(){
				this.$axios.post("TeaInfoController/save",this.tea)
				.then(rst=>{
					let resultJson=rst.data;
					if(resultJson.code==200){
						this.$message("添加成功");
						this.tea={
							teaName:'',
							teaSex:'1',
							teaEmail:'',
							teaType:'2'
						}
					}else{
						this.$message("添加失败");
					}
				}).catch(err=>{
					
				})
			}
		}
	}
</script>

<style scoped>
	#addTeaContainer{
		width: 500px;
		margin-top: 20px;
	}
	.el-select{
		width: 100%;
	}
</style>