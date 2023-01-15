import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:flutter_hooks/flutter_hooks.dart';

class MethodChannelBridge extends HookWidget {
  const MethodChannelBridge({Key? key}) : super(key: key);
  static const platform = MethodChannel('flutter.native/helper');
  @override
  Widget build(BuildContext context) {
    final response = useState<String>("");

    useEffect(() {
      getMessageFromJava(response);
      return null;
    }, const []);

    return Scaffold(
      appBar: AppBar(
        title: const Text(''),
      ),
      body: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          Text(
            response.value,
            style: const TextStyle(fontSize: 40),
            textAlign: TextAlign.center,
          ),
          ElevatedButton(
            onPressed: () {
              platform.invokeMethod('openReactNative');
            },
            child: const Text('Abrir tela native'),
          )
        ],
      ),
    );
  }

  static Future<void> getMessageFromJava(ValueNotifier<String> response) async {
    try {
      final String result = await platform.invokeMethod('helloFromNativeCode');
      response.value = result;
    } on PlatformException catch (e) {
      response.value = "Failed to Invoke: '${e.message}'.";
    }
  }
}
