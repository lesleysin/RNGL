#import <React/RCTLog.h>
#import <React/RCTUIManager.h>
#import <React/RCTViewManager.h>

@interface RNGLLIBManager : RCTViewManager
@end

@implementation RNGLLIBManager

RCT_EXPORT_MODULE(RNGLLIB)

- (UIView *)view
{
  return [[UIView alloc] init];
}

RCT_EXPORT_VIEW_PROPERTY(text, NSString)

@end