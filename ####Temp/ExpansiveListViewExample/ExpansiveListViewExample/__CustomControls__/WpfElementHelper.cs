using System;
using System.Windows;
using System.Windows.Markup;
using System.Windows.Media;
using System.Xml.Linq;


namespace ExpansiveListViewExample
{
    public static class WpfElementHelper
    {
        //public static FrameworkElement FindChildElement(FrameworkElement pfe, string nm)
        //{
        //    FrameworkElement rfe = null;

        //    int l = VisualTreeHelper.GetChildrenCount(pfe);
        //    for (int i = 0; i < l; i++)
        //    {
        //        DependencyObject cdo = VisualTreeHelper.GetChild(pfe, i);
        //        if (cdo is FrameworkElement cfe)
        //        {
        //            if (cfe.Name == nm)
        //            {
        //                rfe = cfe;
        //                break;
        //            }

        //            FindChildElement(cfe, nm);
        //        }
        //    }

        //    return rfe;
        //}

        public static T FindChild<T>(FrameworkElement pfe, string nm) where T : FrameworkElement
        {
            T rfe = null;

            int l = VisualTreeHelper.GetChildrenCount(pfe);
            for (int i = 0; i < l; i++)
            {
                DependencyObject cdo = VisualTreeHelper.GetChild(pfe, i);
                if (cdo is FrameworkElement cfe)
                {
                    if ((cfe is T tfe) &&
                        ((nm == null) || (cfe.Name == nm)))
                    {
                        rfe = tfe;
                        break;
                    }

                    rfe = FindChild<T>(cfe, nm);
                    if (rfe != null) break;
                }
            }

            return rfe;
        }

        public static string PrintXaml(FrameworkElement cfe)
        {
            try
            {
                string strXaml = XamlWriter.Save(cfe);
                XDocument xdoc = XDocument.Parse(strXaml);
                string rst = xdoc.ToString();
                return rst;
            }
            catch
            {
                return null;
            }
        }


    }
}
