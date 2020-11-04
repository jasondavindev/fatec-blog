<template>
  <div class="home">
    <UserRegister></UserRegister>
    <UserLogin></UserLogin>
  </div>
</template>

<script>
import UserRegister from './UserRegister';
import UserLogin from './UserLogin';

export default {
  components: {
    UserRegister,
    UserLogin,
  },
};
</script>
