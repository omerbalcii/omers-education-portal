// Utils/axiosconfig.ts

import axios from 'axios';

const instance = axios.create({
  baseURL: 'http://localhost:8081/', // Backend URL'nizi buraya ekleyin
  timeout: 10000, // İstek zaman aşımı süresi (opsiyonel)
  headers: {
    'Content-Type': 'application/json',
    // İsteğe bağlı olarak diAğer başlık ayarlarını buraya ekleyebilirsiniz
  },
});

export default instance;
