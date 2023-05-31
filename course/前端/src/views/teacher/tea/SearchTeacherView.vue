<template>
	<div id="searchContainer">
		<div id="searchContent">
			<el-form label-width="120px">
				<el-form-item label="教师姓名:">
					<el-input v-model="tea.teaName"></el-input>
				</el-form-item>
				<el-form-item label="教师性别:">
					<el-select v-model="tea.teaSex">
						<el-option label="所有" value="0"></el-option>
						<el-option label="男" value="1"></el-option>
						<el-option label="女" value="2"></el-option>
					</el-select>
				</el-form-item>
				<el-form-item label="教师身份:">
					<el-select v-model="tea.teaType">
						<el-option label="所有" value="0"></el-option>
						<el-option label="教师" value="2"></el-option>
						<el-option label="管理员" value="1"></el-option>
					</el-select>
				</el-form-item>
				<el-form-item>
					<el-button @click="search">搜索</el-button>
				</el-form-item>
			</el-form>
		</div>
		<div id="searchResult">
			<el-table :data="teas" border>
				<el-table-column label="序号" prop="teaId"></el-table-column>
				<el-table-column label="姓名" prop="teaName"></el-table-column>
				<el-table-column label="性别" >
					<template #default="scope">
						{{scope.row.teaSex==1?'男':'女'}}
					</template>
				</el-table-column>
				<el-table-column label="邮箱" prop="teaEmail"></el-table-column>
				<el-table-column label="身份">
					<template #default="scope">
						{{scope.row.teaType==1?'管理员':'教师'}}
					</template>
				</el-table-column>
				<el-table-column label="状态">
					<template #default="scope">
						{{scope.row.teaStatus==1?'在职':'离职'}}
					</template>
				</el-table-column>
				<el-table-column label="操作">
					<template #default="scope">
						<router-link to="#" @click="showEditDialog(scope.row)">编辑</router-link>
						<router-link to="#" @click="showDeleteDialog(scope.row)">删除</router-link>
					</template>
				</el-table-column>
			</el-table>
		</div>
	</div>
	<!-- 删除教师对话框 -->
	  <el-dialog
	    v-model="deleteDialogVisible"
	    title="提示"
	    width="30%"
	    align-center
	  >
	    <span>您确定要删除【{{param.teaName}}】吗?</span>
	    <template #footer>
	      <span class="dialog-footer">
	        <el-button @click="deleteDialogVisible = false">取消</el-button>
	        <el-button type="primary" @click="doDelete">
	          确定
	        </el-button>
	      </span>
	    </template>
	  </el-dialog>
	  <!-- 修改教师的对话框 -->
	  
	    <el-dialog
	      v-model="editDialogVisible"
	      title="编辑"
	      width="30%"
	      align-center
	    >
		<div id="editTeacherContainer">
			<el-form label-width="120px">
				<el-form-item label="教师姓名:">
					<el-input v-model="param.teaName"></el-input>
				</el-form-item>
				<el-form-item label="教师性别:">
					<el-select v-model="param.teaSex">
						<el-option label="男" :value="1"></el-option>
						<el-option label="女" :value="2"></el-option>
					</el-select>
				</el-form-item>
				<el-form-item label="教师邮箱:">
					<el-input v-model="param.teaEmail"></el-input>
				</el-form-item>
				<el-form-item label="教师身份:">
					<el-select v-model="param.teaType">
						<el-option label="管理员" :value="1"></el-option>
						<el-option label="教师" :value="2"></el-option>
					</el-select>
				</el-form-item>
				<el-form-item label="教师状态:">
					<el-select v-model="param.teaStatus">
						<el-option label="在职" :value="1"></el-option>
						<el-option label="离职" :value="2"></el-option>
					</el-select>
				</el-form-item>
			</el-form>
		</div>
	      <template #footer>
	        <span class="dialog-footer">
	          <el-button @click="editDialogVisible = false">取消</el-button>
	          <el-button type="primary" @click="doEdit">
	            确定
	          </el-button>
	        </span>
	      </template>
	    </el-dialog>
</template>

<script>
	export default{
		name:'SearchTeacherView',
		data(){
			return{
				tea:{
					teaName:'',
					teaSex:'0',
					teaType:'0'
				},
				teas:[],
				deleteDialogVisible:false,
				param:{},
				editDialogVisible:false
			}
		},
		methods:{
			search(){
				this.$axios.post("TeaInfoController/findByParam",this.tea)
				.then(rst=>{
					this.teas=rst.data.data;
				}).catch(err=>{
					
				})
			},
			showDeleteDialog(row){
				this.param=row;
				this.deleteDialogVisible=true;
			},
			doDelete(){
				this.$axios.post("TeaInfoController/delete",this.param)
				.then(rst=>{
					if(rst.data.code==200){
						this.$message("操作成功!");
						this.search()
					}else{
						this.$message("操作失败!")
					}
					this.deleteDialogVisible=false;
				})
			},
			showEditDialog(row){
				this.param=row;
				this.editDialogVisible=true;
			},
			doEdit(){
				this.$axios.post("TeaInfoController/edit",this.param)
				.then(rst=>{
					if(rst.data.code==200){
						this.$message("操作成功!");
						this.search()
						this.editDialogVisible=false;
					}else{
						this.$message("操作失败!")
					}
					
				})
			}
		}
	}
</script>

<style scoped>
	#searchContent{
		width: 500px;
		margin-top: 20px;
	}
	.el-select{
		width:100%;
	}
	#searchResult{
		margin: 0px 50px;
	}
	#searchResult a{
		margin-right: 5px;
	}
	#editTeacherContainer{
		margin-right: 60px;
	}
</style>