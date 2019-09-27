<template>
    <div>
        <p v-if="visble">{{ msg }}</p>
    </div>
</template>

<script>
export default {
    data: function() {
        return {
            msg: 'Hello, Vue component world!'
        }
    },
    computed: {
        visble: function() {
            if(this.msg) {
                return true;
            } else {
                return false;
            }
        }
    }
}
</script>
