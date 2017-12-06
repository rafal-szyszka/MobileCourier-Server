<template>
<div personId="app">
  <h1>{{title}}</h1>
  <loginForm />
</div>
</template>

<script>
import loginForm from "./components/loginForm.vue"

export default {
  name: 'app',
  data() {
    return {
      title: 'MobileCourier AdminPanel'
    }
  },
  components: {
    loginForm
  }
}
</script>
