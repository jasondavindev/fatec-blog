<template>
  <div class="top-bar-user">
    <div class="text-right">
      <b-button variant="primary" @click="logout">Sair</b-button>
    </div>
  </div>
</template>

<script>
import { mapActions } from 'vuex';

export default {
  methods: {
    ...mapActions(['clearSession']),

    logout() {
      this.clearSession();
      this.$router.push('/');
    },
  },
};
</script>

<style>
.top-bar-user {
  padding: 10px;
  border-bottom: solid 1px rgba(0, 0, 0, 0.2);
}
</style>
