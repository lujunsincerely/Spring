/**
 * Created by twx on 2017/3/18.
 */
var Cat = {
    createNew: function(){
        var cat = {}
        cat.name = "大毛";
        cat.makeSound = function(){ alert("喵喵喵"); };
        return cat;
    }
};
