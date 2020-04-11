import Vue from 'vue';
import axios from 'axios';
import './common/common.js'
import hello from './components/hello'

new Vue({
    el: '#vue-module',
    components: {
        'hello': hello
    },
    data: {
        items: []
    },
    mounted: function() {
        this.ajax();
    },
    methods: {
        async ajax() {
            let res = await axios.get('/vue');
            this.items = res.data;
        }
    }
});
