using System.Collections.Generic;
using System.ComponentModel;
using System.Diagnostics;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Input;
using System.Windows.Media;


namespace ExpansiveListViewExample
{
    public sealed partial class ListViewItemEx99 : ListViewItem
    {
        #region ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 0)
        private static void prPrintOut(string msg)
        {
            Debug.WriteLine(msg);
        }

        private static readonly List<ListViewItemEx99> _lst = new List<ListViewItemEx99>();


        public ListViewItemEx99()
        {
            InitializeComponent();
            Loaded += ppLoaded;
        }

        private void ppLoaded(object sd, RoutedEventArgs ea)
        {
            Loaded -= ppLoaded;

            //m_bsi = (BaseInfo)Content;
            //m_bdrt = WpfElementHelper.FindChild<Border>(this, "_bdrt");
            //m_gvrp = WpfElementHelper.FindChild<GridViewRowPresenter>(m_bdrt, null);
            //m_ckb = WpfElementHelper.FindChild<CheckBox>(m_gvrp, "_ccb");

            //m_bsi.PropertyChanged += delegate (object _, PropertyChangedEventArgs e)
            //{
            //    if (e.PropertyName == "Checked")
            //    {
            //        prUpdateState();
            //    }
            //};
            //prUpdateState();

            _lst.Add(this);

            //VirtualizingStackPanel xx;
            //xx.
        }

        private BaseInfo m_bsi;
        private BaseInfo prGetBaseInfo()
        {
            m_bsi = Content as BaseInfo;
            return m_bsi;
        }

        private Border m_bdrt;
        private Border prGetBorder()
        {
            if (m_bdrt == null)
                m_bdrt = WpfElementHelper.FindChild<Border>(this, "_bdrt");
            return m_bdrt;
        }
        private void prSetBorderBackground(Brush brs)
        {
            Border bdrt = prGetBorder();
            if (bdrt != null)
                bdrt.Background = brs;
        }
        private void prSetBorderBrush(Brush brs)
        {
            Border bdrt = prGetBorder();
            if (bdrt != null)
                bdrt.BorderBrush = brs;
        }

        private CheckBox m_ckb;
        private CheckBox prGetCheckBox()
        {
            if (m_ckb == null)
                m_ckb = WpfElementHelper.FindChild<CheckBox>(this, "_ccb");
            return m_ckb;
        }
        private void prSetCheckBoxChecked(bool b)
        {
            CheckBox ckb = prGetCheckBox();
            if (ckb != null)
                ckb.IsChecked = b;
        } 
        #endregion

        //protected override void OnVisualParentChanged(DependencyObject pdo)
        //{
        //    prUpdateState();

        //    base.OnVisualParentChanged(pdo);
        //}        

        private void prUpdateState()
        {
            if (m_bsi != null)
            {
                bool b = m_bsi.Checked;
                if (!b)
                {

                }
                IsSelected = b;
                prCheckUpdateSelected(IsSelected);
                prPrintOut(">>>");
            }
        }

        //public override void OnApplyTemplate()
        //{
        //    base.OnApplyTemplate();

        //    //var x0 = Template.FindName("_bdrt", this);
        //    //var x1 = ContentTemplate.FindName("_ccb", this);
        //    //VisualP
        //    //(GridView)ViewBase;
        //    //var x5 = WpfElementHelper.FindChild<GridViewRowPresenter>(this, null);
        //    //var x6 = GridViewRowPresenterHelper.FindVisualChild<GridViewRowPresenter>(this, null);
        //    //_gvrp = WpfElementHelper.FindChild<GridViewRowPresenter>(this, null);
        //    //_ckb = WpfElementHelper.FindChild<CheckBox>(_gvrp, "_ccb");
        //}

        protected override void OnPreviewMouseRightButtonDown(MouseButtonEventArgs ea)
        {
            ea.Handled = true;

            base.OnPreviewMouseRightButtonDown(ea);
        }

        private void prCheckUpdateSelected(bool b)
        {
            if (b)
            {
                prSetBorderBackground(Brushes.PeachPuff);
                prSetBorderBrush(Brushes.DarkOrange);
                prSetCheckBoxChecked(true);
            }
            else
            {
                prSetBorderBackground(Brushes.Transparent);
                prSetBorderBrush(Brushes.Transparent);
                prSetCheckBoxChecked(false);
            }
        }

        private void prBaseInfoPropertyChangedCallback(string pnm)
        {
            if (pnm == "Checked")
            {
                BaseInfo bsi = prGetBaseInfo();
                if (bsi != null)
                {
                    if (bsi.Checked != IsSelected)
                    {
                        IsSelected = bsi.Checked;
                    }
                }
            }
        }

        protected override void OnContentChanged(object oc, object nc)
        {
            //prPrintOut("OnContentChanged");
            BaseInfo bsi = prGetBaseInfo();
            if (bsi != null)
            {
                if (bsi.PropertyChangedCallback == null)
                    bsi.PropertyChangedCallback = prBaseInfoPropertyChangedCallback;
            }

            base.OnContentChanged(oc, nc);
        }

        protected override void OnUnselected(RoutedEventArgs ea)
        {
            prPrintOut("OnUnselected");

            if (Content is BaseInfo)
            {
                prCheckUpdateSelected(false);
            }

            base.OnUnselected(ea);
        }

        protected override void OnSelected(RoutedEventArgs ea)
        {
            prPrintOut("OnSelected");

            if (Content is BaseInfo)
            {
                prCheckUpdateSelected(true);
            }

            base.OnSelected(ea);
        }




        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        //protected virtual void OnContentChanged(object oldContent, object newContent);
        //protected virtual void OnContentStringFormatChanged(string oldContentStringFormat, string newContentStringFormat);
        //protected virtual void OnContentTemplateChanged(DataTemplate oldContentTemplate, DataTemplate newContentTemplate);
        //protected virtual void OnContentTemplateSelectorChanged(DataTemplateSelector oldContentTemplateSelector, DataTemplateSelector newContentTemplateSelector);

        /*
        protected override void OnContentChanged(object oldContent, object newContent)
        {
            //prPrintOut("OnContentChanged");

            base.OnContentChanged(oldContent, newContent);
        }

        protected override void OnContentStringFormatChanged(string oldContentStringFormat, string newContentStringFormat)
        {
            //prPrintOut("OnContentStringFormatChanged");

            base.OnContentStringFormatChanged(oldContentStringFormat, newContentStringFormat);
        }

        protected override void OnContentTemplateChanged(DataTemplate oldContentTemplate, DataTemplate newContentTemplate)
        {
            //prPrintOut("OnContentTemplateChanged");

            base.OnContentTemplateChanged(oldContentTemplate, newContentTemplate);
        }

        protected override void OnContentTemplateSelectorChanged(DataTemplateSelector oldContentTemplateSelector, DataTemplateSelector newContentTemplateSelector)
        {
            //prPrintOut("OnContentTemplateSelectorChanged");

            base.OnContentTemplateSelectorChanged(oldContentTemplateSelector, newContentTemplateSelector);
        }
        */

    }
}
