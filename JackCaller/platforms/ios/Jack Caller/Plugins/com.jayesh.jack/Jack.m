/********* Jack.m Cordova Plugin Implementation *******/

#import <Cordova/CDV.h>

@interface Jack : CDVPlugin {
  // Member variables go here.
}

- (void)callJack:(CDVInvokedUrlCommand*)command;
@end

@implementation Jack

- (void)callJack:(CDVInvokedUrlCommand*)command
{
    CDVPluginResult* pluginResult = nil;

    NSString *appId = [[command.arguments objectAtIndex:0] valueForKey:@"appId"];
    NSString *sessionId = [[command.arguments objectAtIndex:0] valueForKey:@"sessionId"];
    NSString *tokenId = [[command.arguments objectAtIndex:0] valueForKey:@"tokenId"];
    


    if (appId != nil && [appId length] > 0) 
    {
      //  NSString* total = (@"iOS Received  %@  ,  %@   , %@" , appId , sessionId, tokenId);
        NSString* total = [NSString stringWithFormat:@"%@ %@ %@",  appId , sessionId,tokenId ];
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:total];
        [self showNib];
    } else {
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR];
    }

    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];

}

- (void) showNib
{
    
    UIView *containerView = [[[NSBundle mainBundle] loadNibNamed:@"ViewTest" owner:self options:nil] lastObject];
    [self.viewController.view addSubview:containerView];

}

@end
