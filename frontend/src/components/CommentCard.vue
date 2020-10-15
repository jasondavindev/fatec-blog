<template>
  <div class="comment-card">
    <h4>{{ this.user }}</h4>
    <p>{{ this.commentary }}</p>
  </div>
</template>

<script>
export default {
  props: ['user', 'commentary'],
};
</script>
