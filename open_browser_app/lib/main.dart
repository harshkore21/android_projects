import 'package:flutter/material.dart';
import 'package:url_launcher/url_launcher.dart';

void main() {
  runApp(OpenBrowserApp());
}

class OpenBrowserApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Open Browser App',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: BrowserHomePage(),
    );
  }
}

class BrowserHomePage extends StatelessWidget {
  final Uri url = Uri.parse('https://www.google.com');

  Future<void> _openBrowser() async {
    if (!await launchUrl(
      url,
      mode: LaunchMode.externalApplication,
    )) {
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
          onPressed: _openBrowser,
          child: Text('Open Browser'),
        ),
      ),
    );
  }
}
