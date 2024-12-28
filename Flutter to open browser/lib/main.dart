import 'package:flutter/material.dart';
import 'package:url_launcher/url_launcher.dart' as url_launcher;

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Open Browser App',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: MyHomePage(),
    );
  }
}

class MyHomePage extends StatelessWidget {
  // Function to open the URL
  void _openBrowser() async {
    const url = 'https://imr.dypvp.edu.in';
    if (await url_launcher.canLaunch(url)) {
      await url_launcher.launch(url); // Launch the URL in the default browser
    } else {
      throw 'Could not launch $url';
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Open Browser App'),
      ),
      body: Center(
        child: ElevatedButton(
          onPressed: _openBrowser, // Call the function on button press
          child: Text('Open Browser'),
        ),
      ),
    );
  }
}
