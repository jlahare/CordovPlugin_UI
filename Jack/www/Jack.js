var exec = require('cordova/exec');

exports.callJack = function (jsonObj, success, error) 
{
    exec(success, error, 'Jack', 'callJack', [jsonObj]);
};
