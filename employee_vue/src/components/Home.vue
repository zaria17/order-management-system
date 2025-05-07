<template>
    <div style="text-align: center;background-color: #f1f1f3;height: 100%;padding: 0px;margin: 0px;">

        <h1 style="font-size: 50px;">{{'欢迎你！'+user.姓氏+user.名字}}</h1>
        <el-descriptions  title="个人中心" :column="2" size="40" border>

            <el-descriptions-item>

                <template slot="label">
                    <i class="el-icon-s-custom"></i>
                  姓名与头像
                </template>
              <img :src="imageSrc" alt="Image" style="width: 120px; height: 160px"/>
                {{user.姓氏+user.名字}}
            </el-descriptions-item>
            <el-descriptions-item>
                <template slot="label">
                    <i class="el-icon-mobile-phone"></i>
                    家庭电话
                </template>
                {{user.家庭电话}}
            </el-descriptions-item>
            <el-descriptions-item>
                <template slot="label">
                    <i class="el-icon-location-outline"></i>
                  国家
                </template>
              {{user.国家}}
            </el-descriptions-item>
            <el-descriptions-item>
                <template slot="label">
                    <i class="el-icon-tickets"></i>
                  城市
                </template>
              {{user.城市 }}
            </el-descriptions-item>
          <el-descriptions-item>
            <template slot="label">
              <i class="el-icon-s-custom"></i>
              职务
            </template>
            {{user.职务}}
          </el-descriptions-item>
          <el-descriptions-item>
            <template slot="label">
              <i class="el-icon-mobile-phone"></i>
              尊称
            </template>
            {{user.尊称}}
          </el-descriptions-item>
          <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-location-outline"></i>
            地区
          </template>
          {{user.地区}}
          </el-descriptions-item>
          <el-descriptions-item>
            <template slot="label">
              <i class="el-icon-tickets"></i>
              地址
            </template>
            {{user.地址 }}
          </el-descriptions-item>
          <el-descriptions-item>
            <template slot="label">
              <i class="el-icon-s-custom"></i>
              出生日期
            </template>
            {{user.出生日期}}
          </el-descriptions-item>
          <el-descriptions-item>
            <template slot="label">
              <i class="el-icon-mobile-phone"></i>
              邮政编码
            </template>
            {{user.邮政编码}}
          </el-descriptions-item>
          <el-descriptions-item>
            <template slot="label">
              <i class="el-icon-s-custom"></i>
              备注
            </template>
            {{user.备注}}

          </el-descriptions-item>
        </el-descriptions>

      <el-button :plain="true" type="primary" style="margin-left: 5px;margin-top: 10px;" @click="mod">编辑</el-button>
      <el-dialog
          title="提示"
          :visible.sync="centerDialogVisible"
          width="30%"
          center>
        <el-form ref="form" :model="form" label-width="80px">
          <el-form-item label="姓氏" >
            <el-input v-model="form.姓氏"></el-input>
          </el-form-item>
          <el-form-item label="名字" >
            <el-input v-model="form.名字"></el-input>
          </el-form-item>
          <el-form-item label="国家" >
            <el-input v-model="form.国家"></el-input>
          </el-form-item>
          <el-form-item label="职务" >
            <el-input v-model="form.职务"></el-input>
          </el-form-item>
          <el-form-item label="地区" >
            <el-input v-model="form.地区"></el-input>
          </el-form-item>
          <el-form-item label="出生日期" >
            <el-input v-model="form.出生日期"></el-input>
          </el-form-item>
          <el-form-item label="家庭电话" >
            <el-input v-model="form.家庭电话"></el-input>
          </el-form-item>
          <el-form-item label="城市" >
            <el-input v-model="form.城市"></el-input>
          </el-form-item>
          <el-form-item label="尊称" >
            <el-input v-model="form.尊称"></el-input>
          </el-form-item>
          <el-form-item label="地址" >
            <el-input v-model="form.地址"></el-input>
          </el-form-item>
          <el-form-item label="邮政编码" >
            <el-input v-model="form.邮政编码"></el-input>
          </el-form-item>
          <el-form-item label="密码" >
            <el-input v-model="form.密码"></el-input>
          </el-form-item>
          <template>
            <div>
              <div class="touxiang">
                <div class="pic">
                  <img
                      v-if="imageUrl"
                      :src="imageUrl ? '' + imageUrl : '@/assets/avatar.gif'"
                      class="avatar"
                  />
                  <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                </div>
                <el-upload
                    class="avatar-uploader"
                    list-type="picture"
                    ref="upload"
                    accept=".jpg, .png"
                    action="#"
                    :limit="1"
                    :auto-upload="false"
                    :show-file-list="false"
                    :file-list="fileList"
                    :on-change="getFile"
                >
                  <el-button size="small" type="primary">点击上传</el-button>

                </el-upload>
              </div>

              <!--    <button size="small" type="primary" @click="loginClick">上传</button>-->
            </div>
          </template>
        </el-form>
        <span slot="footer" class="dialog-footer">
    <el-button @click="centerDialogVisible = false" >取 消</el-button>
    <el-button type="primary" @click="save">确 定</el-button>
  </span>
      </el-dialog>


      <DateUtils></DateUtils>

    </div>
</template>

<script>
    import DateUtils from "./DateUtils";
    export default {
        name: "Home",
        components: {DateUtils},
        data() {

            return {
              imageSrc:'',
              obj:'',
              // 上传头像地址
              imageUrl: '',
              //接收上传的文件
              fileList: [],
              tableData:[],
              user:{},
              centerDialogVisible:false,
              form:{
                雇员id:'',
                姓氏:'',
                名字:'',
                国家:'',
                职务:'',
                地区:'',
                出生日期:'',
                雇用日期:'',
                家庭电话:'',
                城市:'',
                尊称:'',
                地址:'',
                邮政编码:'',
                备注:'',
                照片:'',
                密码:'',
              }
            }
        },
        computed:{

        },
        methods:{
          //头像上传
          // ruleForm: undefined,
          getFile(file) {
            if (this.beforeAvatarUpload(file)) {
              this.getBase64(file.raw).then((res) => {
                this.imageUrl = res;
                this.form.照片=this.imageUrl
                console.log(this.imageUrl)
                //ruleForm是我接收后端传过来的数据，此处可以忽略
                // this.ruleForm.imagePath = res;
              });
            }
          },

          //这里是文件转base64
          getBase64(file) {
            this.obj= new Promise(function (resolve, reject) {
              const reader = new FileReader();
              let imgResult = "";
              reader.readAsDataURL(file);
              reader.onload = function () {
                imgResult = reader.result;
              };
              reader.onerror = function (error) {
                reject(error);
              };
              reader.onloadend = function () {
                resolve(imgResult);
              };
            });
            console.log(this.obj)
            return this.obj
          },
          beforeAvatarUpload(file) {
            const isLt2M = file.size / 1024 / 1024 < 2;
            if (!isLt2M) {
              this.$message.error("上传头像图片大小不能超过 2MB!");
            }
            return isLt2M;
          },
          mod() {
            this.centerDialogVisible = true;
            this.$axios.post('http://localhost:8090/雇员/listP2', {
                  "雇员id":this.user.雇员id
                }
            ).then(res => res.data).then(res => res.data).then(res => {
              console.log(res)
              this.tableData = res
              console.log(this.tableData)
              this.form.雇员id = this.tableData[0].雇员id
              this.form.姓氏 = this.tableData[0].姓氏
              this.form.名字 = this.tableData[0].名字
              this.form.国家 = this.tableData[0].国家
              this.form.职务 = this.tableData[0].职务
              this.form.地区 = this.tableData[0].地区
              this.form.出生日期 = this.tableData[0].出生日期
              this.form.家庭电话 = this.tableData[0].家庭电话
              this.form.城市 = this.tableData[0].城市
              this.form.尊称 = this.tableData[0].尊称
              this.form.地址 = this.tableData[0].地址
              this.form.邮政编码 = this.tableData[0].邮政编码
              this.form.备注 = this.tableData[0].备注
              this.form.密码 = this.tableData[0].密码
              console.log(this.form)
            })
              //赋值到表单
          },
          putimg(){
            this.$axios.post('http://localhost:8090/雇员/getimage',{
                  "雇员id":this.user.雇员id
                }
            ).then(res => res.data).then(res => {
              console.log(222)
              const base64Data =res
              this.imageSrc = base64Data
              console.log(this.imageSrc)
            })
          },
          resetForm() {
            this.$refs.form.resetFields();
          },
          save(){
            this.$axios.post('http://localhost:8090/雇员/mod', this.form).then(res => res.data).then(res => {
              console.log(res)
              this.tableData = res
              if (res.code = 200) {
                //alert('suc')
                this.$message({
                  message: '操作成功！',
                  type: 'success'
                });
                this.centerDialogVisible = false
                this.loadPost()
                this.resetForm()
              } else {
                this.$message({
                  message: '操作失败！',
                  type: 'error'
                });
              }
            })
          },
          loadGet() {
            this.$axios.get('http://localhost:8090/雇员/list').then(res => res.data).then(res => {
              console.log(res)
              this.tableData = res
            })
          },
          loadPost() {
            this.$axios.post('http://localhost:8090/雇员/listP2', {
                  "雇员id":this.user.雇员id
                }
            ).then(res => res.data).then(res => res.data).then(res => {
              console.log(res)
              this.tableData = res
              console.log(this.tableData)
            })
          },
            init(){
                this.user = JSON.parse(sessionStorage.getItem('CurUser'))
            },

        },
        created(){
            this.init()
          this.putimg()
        }
    }
</script>

<style scoped>
    .el-descriptions{
        width:90%;

        margin: 0 auto;
        text-align: center;
    }
</style>