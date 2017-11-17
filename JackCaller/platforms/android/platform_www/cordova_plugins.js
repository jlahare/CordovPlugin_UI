cordova.define('cordova/plugin_list', function(require, exports, module) {
module.exports = [
  {
    "id": "com.jayesh.jack.Jack",
    "file": "plugins/com.jayesh.jack/www/Jack.js",
    "pluginId": "com.jayesh.jack",
    "clobbers": [
      "cordova.plugins.Jack"
    ]
  }
];
module.exports.metadata = 
// TOP OF METADATA
{
  "cordova-plugin-whitelist": "1.3.3",
  "com.jayesh.jack": "0.0.1"
};
// BOTTOM OF METADATA
});