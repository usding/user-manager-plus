import React, { ReactElement } from 'react'
import zhCN from 'antd/es/locale/zh_CN'
import { Form, Input, Select, Button, DatePicker, ConfigProvider, Divider, InputNumber, Upload, message, Row, Col } from 'antd'
import { DeleteOutlined } from '@ant-design/icons'
import moment from 'moment'
import { connect } from 'umi'
import ImageUtil from '@/util/ImageUtil'
import axios from '@/util/Axios'

class AddStudent extends React.Component<any, any> {
    state: any
    dateFormat = 'YYYY/MM/DD'
    constructor (props: any) {
      super(props)
      this.state = {
        idcardFrontImg: null,
        idcardBackImg: null,
        diplomaImg: null,
        portraitImg: null,
        initValues: null
      }
    }

    layout = {
      labelCol: { span: 4 },
      wrapperCol: { span: 12 }
    }

    buttonLyout = {
      wrapperCol: { offset: 8, span: 16 }
    }

    onFinish (values: any): void {
      const student = {
        id: null,
        userName: values.studentName,
        birthDate: values.birthDate.format('YYYY-MM-DD'),
        userSex: values.gender,
        celebrities: values.race,
        certType: values.idenType,
        certNumber: values.idenId,
        maritalStatus: values.married,
        localEstate: values.localHouse,
        phoneNumber: values.phoneNumber,
        domicile: values.hometown,
        certAddress: values.idenAddress,
        accompanyPerson: values.followed,
        postalCode: values.mailcode,
        email: values.email,
        wechat: values.wechat,
        note: values.note,
        batch: parseInt(values.batch),
        deposit: values.deposit,
        finalPayment: values.retainage,
        totalCost: values.totalCost,
        certFscan: this.state.idcardFrontImg,
        certBscan: this.state.idcardBackImg,
        photoBlue: this.state.portraitImg,
        certGscan: this.state.diplomaImg
      }
      if (student.certFscan === null || student.certBscan === null || student.photoBlue === null) {
        message.warning('不要忘记上传必需的照片')
        return
      }
      if (this.props.route.path === '/addStudent') {
        axios.post('/student/addStudent', student).then(({ data }) => {
          if (data.success) {
            message.success('添加学员成功')
          }
        })
      } else if (this.props.route.path === '/editStudent') {
        student.id = this.props.ALL.editStudent.id
        axios.post('/student/editStudent', student).then(({ data }) => {
          if (data.success) {
            message.success('编辑成功')
          }
        })
      }
    }

    imgToBase64 (file: File): Promise<any> {
      return new Promise((resolve, reject) => {
        const reader = new FileReader()
        reader.readAsDataURL(file)
        reader.onload = (e) => {
          resolve(reader.result)
        }
      })
    }

    getStudentById (id: number): void {
      axios.get('/student/getStudent', {
        params: {
          id: id
        }
      }).then(({ data }) => {
        if (data.success) {
          const student = data.data
          this.setState({
            initValues: {
              studentName: student.userName,
              birthDate: moment(student.birthDate),
              gender: student.userSex,
              race: student.celebrities,
              idenType: student.certType,
              idenId: student.certNumber,
              localHouse: student.localEstate,
              married: student.maritalStatus,
              phoneNumber: student.phoneNumber,
              hometown: student.domicile,
              idenAddress: student.certAddress,
              followed: student.accompanyPerson,
              mailcode: student.postalCode,
              email: student.email,
              wechat: student.wechat,
              note: student.note,
              batch: student.batch,
              deposit: student.deposit,
              retainage: student.finalPayment,
              totalCost: student.totalCost
            },
            idcardFrontImg: (student.certFscan && student.certFscan.length > 100) ? student.certFscan : null,
            idcardBackImg: (student.certBscan && student.certBscan.length > 100) ? student.certBscan : null,
            diplomaImg: (student.certGscan && student.certGscan.length > 100) ? student.certGscan : null,
            portraitImg: (student.photoBlue && student.photoBlue.length > 100) ? student.photoBlue : null
          })
        }
      })
    }

    getBatchList (): void{
      axios.get('/batch/batchList').then(({ data }) => {
        if (data.success) {
          console.dir(data.data)
          data.data.forEach((batch: any): void => {
            batch.key = batch.id
          })
          this.props.dispatch({
            type: 'ALL/save',
            payload: {
              batchList: data.data
            }
          })
        }
      })
    }

    componentDidMount (): void {
      if (this.props.route.path === '/editStudent') {
        if (this.props.ALL.editStudent) {
          this.getStudentById(this.props.ALL.editStudent.id)
        }
      } else if (this.props.route.path === '/addStudent') {
        this.setState({
          idcardFrontImg: null,
          idcardBackImg: null,
          diplomaImg: null,
          portraitImg: null
        })
      }
      this.getBatchList()
    }

    componentWillUnmount (): void {
      // this.props.dispatch({
      //     type: 'ALL/save',
      //     payload: {
      //         editStudent: null
      //     }
      // })
    }

    renderBatchList (): ReactElement | ReactElement[] {
      return this.props.ALL.batchList.map((val: any) => {
        return (
          <Select.Option key={val.id} value={val.id}>{val.name}</Select.Option>
        )
      })
    }

    render (): ReactElement | null {
      if (this.props.route.path === '/editStudent' && !this.props.ALL.editStudent) {
        return (
          <h3>请在学员列表中选择一个学员编辑</h3>
        )
      }
      if (this.props.route.path === '/editStudent' && this.state.initValues === null) {
        return null
      }
      return (
        <React.Fragment>
          <Form
            // {...this.layout}
            style={{
              width: '100%'
            }}
            onFinish={this.onFinish.bind(this)}
            initialValues={this.props.route.path === '/editStudent' ? this.state.initValues : null}
          >
            <h3>基础信息</h3>
            <Divider />
            <Row>
              <Col span={8}>
                <Form.Item
                  // labelCol={{ span: 5 }}
                  // wrapperCol={{ span: 17 }}
                  label='学员姓名'
                  name='studentName'
                  rules={[{ required: true, message: '请输入学员姓名' }]}
                >
                  <Input />
                </Form.Item>
              </Col>
              <Col span={3}>
                <Form.Item
                  labelCol={{ span: 12 }}
                  wrapperCol={{ span: 10 }}
                  label='性别'
                  name='gender'
                  rules={[{ required: true, message: '请选择性别' }]}
                >
                  <Select>
                    <Select.Option value='m' >男</Select.Option>
                    <Select.Option value='f' >女</Select.Option>
                  </Select>
                </Form.Item>
              </Col>

              <Col span={5}>
                <Form.Item
                  labelCol={{ span: 12 }}
                  wrapperCol={{ span: 10 }}
                  label='婚姻状况'
                  name='married'
                >
                  <Select>
                    <Select.Option value='y'>已婚</Select.Option>
                    <Select.Option value='n'>未婚</Select.Option>
                  </Select>
                </Form.Item>
              </Col>
              <Col span={4}>
                <Form.Item
                  label='民族'
                  name='race'
                >
                  <Select>
                    <Select.Option value='han'>汉族</Select.Option>
                    <Select.Option value='man'>满族</Select.Option>
                    <Select.Option value='zhuang'>壮族</Select.Option>
                    <Select.Option value='other'>其它</Select.Option>
                  </Select>
                </Form.Item>
              </Col>
            </Row>

            <Row>
              <Col span={4}>
                <Form.Item
                  // labelCol={{ span: 10 }}
                  // wrapperCol={{ span: 12 }}
                  label='证件类型'
                  name='idenType'
                  rules={[{ required: true, message: '请选择证件类型' }]}
                >
                  <Select>
                    <Select.Option value='A'>身份证</Select.Option>
                  </Select>
                </Form.Item>
              </Col>
              <Col span={8}>
                <Form.Item
                  labelCol={{ span: 6 }}
                  wrapperCol={{ span: 17 }}
                  label='证件号码'
                  name='idenId'
                  rules={[{ required: true, message: '请填写证件号码' }]}
                >
                  <Input />
                </Form.Item>
              </Col>
              <Col span={6}>
                <ConfigProvider locale={zhCN}>
                  <Form.Item
                    label='出生日期'
                    name='birthDate'
                    rules={[{ required: true, message: '请选择出生日期' }]}
                  >
                    <DatePicker />

                  </Form.Item>
                </ConfigProvider>
              </Col>

            </Row>

            <Row>
              <Col span={6}>
                <Form.Item
                  label='手机号'
                  name='phoneNumber'
                  rules={[{ required: true, message: '请输入手机号' }, { min: 11, message: '长度小于11位' }, { max: 11, message: '长度大于11位' }]}
                >
                  <Input />
                </Form.Item>
              </Col>
              <Col span={1}></Col>
              <Col span={16}>
                <Form.Item
                  label='户籍所在地'
                  name='hometown'
                  rules={[{ required: true, message: '户籍地址不能为空' }]}
                >
                  <Input />
                </Form.Item>
              </Col>
            </Row>
            <Row>
              <Col span={4}>
                <Form.Item
                  label='本地房产'
                  name='localHouse'
                  rules={[{ required: true, message: '本地房产不能为空' }]}
                >
                  <Select>
                    <Select.Option value='y'>有</Select.Option>
                    <Select.Option value='n'>无</Select.Option>
                  </Select>
                </Form.Item>
              </Col>
              <Col span={4}>
                <Form.Item
                  labelCol={{ span: 12 }}
                  wrapperCol={{ span: 11 }}
                  label='随迁人员'
                  name='followed'
                >
                  <Select>
                    <Select.Option value='y'>是</Select.Option>
                    <Select.Option value='n'>否</Select.Option>
                  </Select>
                </Form.Item>
              </Col>
              <Col span={4}>
                <Form.Item
                  labelCol={{ span: 10 }}
                  wrapperCol={{ span: 14 }}
                  label='邮政编码'
                  name='mailcode'
                >
                  <Input />
                </Form.Item>
              </Col>
              <Col span={6}>
                <Form.Item
                  labelCol={{ span: 8 }}
                  wrapperCol={{ span: 16 }}
                  label='邮箱'
                  name='email'
                  rules={[{ type: 'email', message: '非法的邮箱格式' }]}
                >
                  <Input />
                </Form.Item>
              </Col>
            </Row>

            <Row>
              <Col span={6}>
                <Form.Item
                  label='微信号'
                  name='wechat'
                >
                  <Input />
                </Form.Item>
              </Col>
              <Col span={1}></Col>
              <Col span={14}>
                <Form.Item
                  label='身份证地址'
                  name='idenAddress'
                  rules={[{ required: true, message: '身份证地址不能为空' }]}
                >
                  <Input />
                </Form.Item>
              </Col>
            </Row>
            <Row>
              <Col span={22}>
                <Form.Item
                  label='注释'
                  name='note'
                >
                  <Input />
                </Form.Item>
              </Col>
            </Row>
            <h3>批次与金额</h3>
            <Divider />
            <Row>
              <Col span={4}>
                <Form.Item
                  label='批次'
                  name='batch'
                  rules={[{ required: true, message: '请输入批次' }]}
                >
                  <Select>
                    {this.renderBatchList()}
                  </Select>
                </Form.Item>
              </Col>
              <Col span={6}>
                <Form.Item
                  labelCol={{ span: 6 }}
                  wrapperCol={{ span: 17 }}
                  label='定金'
                  name='deposit'
                  rules={[{ required: true, message: '请输入定金' }]}
                >
                  <InputNumber style={{ width: '100px' }} />
                </Form.Item>
              </Col>
              <Col span={6}>
                <Form.Item
                  label='尾款'
                  name='retainage'
                  rules={[{ required: true, message: '请输入尾款' }]}
                >
                  <InputNumber />
                </Form.Item>
              </Col>
              <Col span={6}>
                <Form.Item
                  label='总费用'
                  name='totalCost'
                  rules={[{ required: true, message: '请输入总费用' }]}
                >
                  <InputNumber />
                </Form.Item>
              </Col>
            </Row>

            <h3>证件照</h3>
            <Divider />
            <Row>
              <Col span={12}>
                <Form.Item
                  labelCol={{ span: 4 }}
                  wrapperCol={{ span: 19 }}
                  label='身份证正面'
                  required
                >
                  {this.renderImg('idcardFrontImg')}
                </Form.Item>
              </Col>
              <Col span={12}>
                <Form.Item
                  labelCol={{ span: 4 }}
                  wrapperCol={{ span: 19 }}
                  label='身份证反面'
                  required
                  rules={[{ required: true, message: '请选择身份证反面图片' }]}
                >
                  {this.renderImg('idcardBackImg')}
                </Form.Item>
              </Col>
            </Row>

            <Row>
              <Col span={12}>
                <Form.Item
                  labelCol={{ span: 4 }}
                  wrapperCol={{ span: 19 }}
                  label='2寸蓝底照片'
                  required
                >
                  {this.renderImg('portraitImg')}
                </Form.Item>
              </Col>
              <Col span={12}>
                <Form.Item
                  labelCol={{ span: 4 }}
                  wrapperCol={{ span: 19 }}
                  label='毕业证书'
                >
                  {this.renderImg('diplomaImg')}
                </Form.Item>
              </Col>

            </Row>

            <Form.Item {...this.buttonLyout} >
              <Button type='primary' htmlType='submit'>确定</Button>
            </Form.Item>
          </Form>
        </React.Fragment>
      )
    }

    renderImg (imgName: string): ReactElement {
      return (
        <Upload
          listType="picture-card"
          className="avatar-uploader"
          showUploadList={false}
          beforeUpload={(file: any): boolean => {
            const isJpgOrPng = file.type === 'image/jpeg' || file.type === 'image/png'
            if (!isJpgOrPng) {
              message.error('You can only upload JPG/PNG file!')
              return isJpgOrPng
            }
            const reader = new FileReader()
            reader.readAsDataURL(file)
            reader.onload = async (): Promise<void> => {
              let img64 = reader.result
              if (typeof img64 === 'string') {
                if (img64.length > 500 * 1024) {
                  img64 = await ImageUtil.compress(img64, { w: 1000, h: 1000, level: 0.9 })
                }
                this.setState({
                  [imgName]: img64
                })
              }
            }
            return isJpgOrPng
          }}
        >
          {this.state[imgName]
            ? <div>
              <img src={this.state[imgName]} alt="avatar" style={{ width: '400px' }} />
              <Button type='danger' icon={<DeleteOutlined />} shape='circle'
                style={{
                  marginTop: '0.5rem'
                }}
                onClick={(e): void => {
                  e.preventDefault()
                  e.stopPropagation()
                  this.setState({
                    [imgName]: null
                  })
                }}
              ></Button>
            </div>
            : (<div>
              <div>点击上传</div>
            </div>)}
        </Upload>
      )
    }
}

export default connect(({ ALL }: { ALL: any }) => ({ ALL }))(AddStudent)
