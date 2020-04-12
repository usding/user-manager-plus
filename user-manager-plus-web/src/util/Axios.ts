import axios from 'axios'
import { message } from 'antd'
import { history } from 'umi'
const Axios = axios.create()
Axios.interceptors.request.use((config) => {
  return config
})
Axios.interceptors.response.use((res) => {
  if (res.data && res.data.success === false) {
    if (res.data.msg) {
      message.error(res.data.msg)
    }
  }
  return res
}, ({ response }) => {
  if (response.status === 401) {
    message.error('未登录，将跳转到登录页')
    history.push('/login')
  } else {
    if (response?.data?.msg) {
      message.error(response.data.msg)
    }
  }
  return response
})
export default Axios
