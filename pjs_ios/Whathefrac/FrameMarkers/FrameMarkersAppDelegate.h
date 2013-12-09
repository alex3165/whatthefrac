/*==============================================================================
 Copyright (c) 2010-2012 QUALCOMM Austria Research Center GmbH.
 All Rights Reserved.
 Qualcomm Confidential and Proprietary
 ==============================================================================*/


#import <UIKit/UIKit.h>
@class ARParentViewController;


@interface FrameMarkersAppDelegate : NSObject <UIApplicationDelegate> {
    UIWindow* window;
    ARParentViewController* arParentViewController;
    UIImageView *splashV;
    UIWebView *webSite;
}

-(void)showPJS;
-(void)hidePJS;

@end